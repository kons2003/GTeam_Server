package com.gteam.gdsc.controller;

import com.gteam.gdsc.dto.Token;
import com.gteam.gdsc.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/oauth2")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public Token PostGoogleCallback( String credential) {
        return loginOrSignup(credential);
    }

    @PostMapping("/login2")
    public Token googleCallbacklogin(String credential) {
        String googleAccessToken = authService.getGoogleAccessToken(credential);
        return loginOrSignup(googleAccessToken);
    }

    @GetMapping("callback/google2")
    public Token googleCallback2(@RequestBody String credential) {
        return loginOrSignup(credential);
    }

    @GetMapping("callback/google")
    public Token googleCallback(@RequestParam(name = "code") String code) {
        String googleAccessToken = authService.getGoogleAccessToken(code);
        return loginOrSignup(googleAccessToken);
    }

    public Token loginOrSignup(String googleAccessToken) {
        return authService.loginOrSignUp(googleAccessToken);
    }
}
