package com.gteam.gdsc.infra.oauth.google.authcode;

import com.gteam.gdsc.domain.OauthServerType;
import com.gteam.gdsc.domain.authcode.AuthCodeRequestUrlProvider;
import com.gteam.gdsc.infra.oauth.google.GoogleOauthConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class GoogleAuthCodeRequestUrlProvider implements AuthCodeRequestUrlProvider {

    private GoogleOauthConfig googleOauthConfig;

    @Override
    public OauthServerType supportServer() {
        return OauthServerType.GOOGLE;
    }

    @Override
    public String provide() {
        return UriComponentsBuilder
                .fromUriString("https://accounts.google.com/o/oauth2/v2/auth")
                .queryParam("response_type", "code")
                .queryParam("client_id", googleOauthConfig.getGoogleClientId())
                .queryParam("redirect_uri", googleOauthConfig.getGoogleRedirctUri())
                .queryParam("scope", String.join(",", googleOauthConfig.getGoogleScope()))
                .toUriString();
    }
}