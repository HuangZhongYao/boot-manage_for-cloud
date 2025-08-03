package org.github.bm.auth.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.auth.dto.LoginDTO;
import org.github.bm.auth.service.IAuthService;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.constant.RedisConstant;
import org.github.bm.common.prop.SecurityProperties;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.common.security.AuthUser;
import org.github.bm.common.security.SecurityConstants;
import org.github.bm.core.service.IRedisService;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.IUserClient;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements IAuthService {
    @Resource
    SecurityProperties securityProperties;
    @Resource
    IRedisService redisService;
    @Resource
    IUserClient userClient;

    @Override
    public AuthInfo login(LoginDTO loginDTO) {


        UserEntity userEntity = userClient.getUserByAccount(loginDTO.getAccount());
        AuthUser authUser = new AuthUser(userEntity.getUsername(), loginDTO.getAccount(), userEntity.getPhone(), userEntity.getEnable());
        authUser.setId(userEntity.getId());

        Date now = new Date();
        JWT jwt = new JWT();

        jwt.setIssuedAt(now);
        jwt.setIssuer(AppConstant.BASE_PACKAGES);
        jwt.setKey(securityProperties.getToken().getSecret().getBytes());
        jwt.setExpiresAt(DateUtil.offsetDay(now, SecurityConstants.JwtConstants.REFRESH_TOKEN_EXPIRED_TIME));

        String refreshToken = jwt.sign();

        jwt.setExpiresAt(DateUtil.offsetHour(now, SecurityConstants.JwtConstants.ACCESS_TOKEN_EXPIRED_TIME));
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER, JSON.toJSONString(authUser));

        String accessToken = jwt.sign();

        AuthInfo authInfo = new AuthInfo();
        authInfo.setAccessToken(accessToken);
        authInfo.setRefreshToken(refreshToken);
        authInfo.setTokenPrefix(securityProperties.getToken().getPrefix());

        redisService.set(RedisConstant.Authorization.REFRESH_TOKEN + userEntity.getId(), refreshToken, RedisConstant.Authorization.REFRESH_TOKEN_CACHE_TIME);
        redisService.set(RedisConstant.Authorization.WEB_AUTHORIZATION_KEY + userEntity.getId(), accessToken, SecurityConstants.JwtConstants.ACCESS_TOKEN_EXPIRED_TIME * 60 * 60);

        return authInfo;
    }

    @Override
    public Boolean loginOut() {
        return true;
    }

    @Override
    public String refreshToken(String refreshToken) {
        return "";
    }
}
