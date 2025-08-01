package org.github.bm.auth.service;

import org.github.bm.common.security.AuthInfo;

public interface IAuthService {
    AuthInfo login();

    Boolean loginOut();
}
