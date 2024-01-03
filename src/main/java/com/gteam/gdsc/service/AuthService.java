package com.gteam.gdsc.service;

import com.google.gson.Gson;
import com.gteam.gdsc.domain.Role;
import com.gteam.gdsc.domain.User;
import com.gteam.gdsc.dto.Token;
import com.gteam.gdsc.dto.GoogleUserInfo;
import com.gteam.gdsc.jwt.TokenProvider;
import com.gteam.gdsc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.security.Principal;
import java.util.Map;

@Service
public class AuthService {

    private final String GOOGLE_TOKEN_URL = "https://oauth2.googleapis.com/token";
    private final String googleClientId;
    private final String googleClientSecret;
    private final String GOOGLE_REDIRECT_URI = "http://localhost:8080/api/oauth2/callback/google";

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;

    public AuthService(@Value("${GOOGLE_CLIENT_ID}") String googleClientId,
                       @Value("${GOOGLE_CLIENT_SECRET}") String googleClientSecret,
                       UserRepository userRepository, TokenProvider tokenProvider) {
        this.googleClientId = googleClientId;
        this.googleClientSecret = googleClientSecret;
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    public String getGoogleAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = Map.of(
                "code", code,
                "scope", "https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email",
                "client_id", googleClientId,
                "client_secret", googleClientSecret,
                "redirect_uri", GOOGLE_REDIRECT_URI,
                "grant_type", "authorization_code"
        );

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(GOOGLE_TOKEN_URL, params, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String json = responseEntity.getBody();
            Gson gson = new Gson();

            return gson.fromJson(json, Token.class)
                    .getAccessToken();
        }

        throw new RuntimeException("구글 엑세스 토큰을 가져오는데 실패했습니다.");
    }

    public Token loginOrSignUp(String googleAccessToken) {
        GoogleUserInfo googleUserInfo = getUserInfo(googleAccessToken);

        if (!googleUserInfo.getVerifiedEmail()) {
            throw new RuntimeException("이메일 인증이 되지 않은 유저입니다.");
        }

        User user = userRepository.findByEmail(googleUserInfo.getEmail()).orElseGet(() ->
                userRepository.save(User.builder()
                        .email(googleUserInfo.getEmail())
                        .name(googleUserInfo.getName())
                        .pictureUrl(googleUserInfo.getPictureUrl())
                        .role(Role.ROLE_USER) // 최초 가입시 USER로 설정
                        .build())
        );

        return tokenProvider.createToken(user);
    }

    public GoogleUserInfo getUserInfo(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + accessToken;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String json = responseEntity.getBody();
            Gson gson = new Gson();
            return gson.fromJson(json, GoogleUserInfo.class);
        }

        throw new RuntimeException("유저 정보를 가져오는데 실패했습니다.");
    }

    public User test(Principal principal) {
        Long id = Long.parseLong(principal.getName());

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
    }
}