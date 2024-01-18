package com.gteam.gdsc.infra.oauth.google;

import org.springframework.beans.factory.annotation.Value;

public class GoogleOauthConfig {

    private String googleRedirctUri;
    private String googleClientId;
    private String googleClientSecret;
    private String googleScope;

    public GoogleOauthConfig(
            @Value("${GOOGLE_REDIRECT_URI}")
            String googleRedirctUri,
            @Value("${GOOGLE_CLIENT_ID}")
            String googleClientId,
            @Value("${GOOGLE_CLIENT_SECRET}")
            String googleClientSecret,
            @Value("${GOOGLE_SCOPE}")
            String googleScope) {
        this.googleRedirctUri = googleRedirctUri;
        this.googleClientId = googleClientId;
        this.googleClientSecret = googleClientSecret;
        this.googleScope = googleScope;
    }
}