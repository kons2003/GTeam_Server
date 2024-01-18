package com.gteam.gdsc.infra.oauth.google;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class GoogleOauthConfig {

    private final String googleRedirctUri;
    private final String googleClientId;
    private final String googleClientSecret;
    private final String googleScope;

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