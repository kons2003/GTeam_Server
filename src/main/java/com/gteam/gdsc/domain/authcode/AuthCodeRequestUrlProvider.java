package com.gteam.gdsc.domain.authcode;

import com.gteam.gdsc.domain.OauthServerType;

public interface AuthCodeRequestUrlProvider {

    OauthServerType supportServer();

    String provide();
}
