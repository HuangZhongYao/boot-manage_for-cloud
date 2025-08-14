package org.github.bm.auth.service;

import org.github.bm.auth.dto.LoginDTO;
import org.github.bm.common.security.AuthInfo;

public interface IAuthService {
    AuthInfo login(LoginDTO loginDTO, String client);

    Boolean loginOut(String client);

    AuthInfo refreshToken(String refreshToken,String client);
}
