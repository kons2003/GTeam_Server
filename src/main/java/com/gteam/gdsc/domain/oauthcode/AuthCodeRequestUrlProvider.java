package com.gteam.gdsc.domain.oauthcode;

import com.gteam.gdsc.domain.OauthServerType;

public interface AuthCodeRequestUrlProvider {

    OauthServerType supportServer();

    String provide();
}
