package org.github.bm.auth.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.github.bm.auth.service.IAuthService;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.prop.SecurityProperties;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.common.security.AuthUser;
import org.github.bm.common.security.SecurityConstants;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements IAuthService {
    @Resource
    SecurityProperties securityProperties;

    @Override
    public AuthInfo login() {

        AuthUser authUser = new AuthUser("bm-user", "admin", "17685306464", true);
        authUser.setId(1999884354L);

        Date now = new Date();
        JWT jwt = new JWT();

        jwt.setIssuedAt(now);
        jwt.setIssuer(AppConstant.BASE_PACKAGES);
        jwt.setKey(securityProperties.getToken().getSecret().getBytes());
        jwt.setExpiresAt(DateUtil.offsetDay(now, 3));

        String refreshToken = jwt.sign();

        jwt.setExpiresAt(DateUtil.offsetHour(now, 1));
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER, JSON.toJSONString(authUser));

        String accessToken = jwt.sign();

        AuthInfo authInfo = new AuthInfo();
        authInfo.setAccessToken(accessToken);
        authInfo.setRefreshToken(refreshToken);
        authInfo.setTokenPrefix(securityProperties.getToken().getPrefix());
        return authInfo;
    }

    @Override
    public Boolean loginOut() {
        return true;
    }
}
