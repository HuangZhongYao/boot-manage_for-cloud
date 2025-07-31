package org.github.bm.auth.service.impl;

import cn.hutool.jwt.JWTUtil;
import jakarta.annotation.Resource;
import org.github.bm.auth.service.IAuthService;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.common.prop.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthServiceImpl implements IAuthService {
    @Resource
    SecurityProperties securityProperties;

    @Override
    public AuthInfo login() {
        HashMap<String, Object> user = new HashMap<>();
        user.put("id", System.currentTimeMillis() / 1000);
        user.put("name", "bm-admin");
        user.put("phone", "9433");
        String token = JWTUtil.createToken(user, securityProperties.getToken().getSecret().getBytes());
        AuthInfo authInfo = new AuthInfo();
        authInfo.setAccessToken(token);
        authInfo.setRefreshToken(token);
        authInfo.setTokenPrefix(securityProperties.getToken().getPrefix());
        return authInfo;
    }
}
