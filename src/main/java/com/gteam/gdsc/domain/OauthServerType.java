package com.gteam.gdsc.domain;

import static java.util.Locale.ENGLISH;

public enum OauthServerType {

    GOOGLE,
    ;

    public static OauthServerType fromName(String type) {
        return OauthServerType.valueOf(type.toUpperCase(ENGLISH));
    }
}
