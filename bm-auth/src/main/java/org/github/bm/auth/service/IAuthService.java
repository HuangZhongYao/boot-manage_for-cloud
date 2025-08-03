package org.github.bm.auth.service;

import org.github.bm.auth.dto.LoginDTO;
import org.github.bm.common.security.AuthInfo;

public interface IAuthService {
    AuthInfo login(LoginDTO loginDTO);

    Boolean loginOut();

    String refreshToken(String refreshToken);
}
