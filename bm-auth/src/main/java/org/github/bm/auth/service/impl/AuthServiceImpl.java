package org.github.bm.auth.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
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
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER, userEntity.getId());

        String refreshToken = jwt.sign();

        jwt.setExpiresAt(DateUtil.offsetHour(now, SecurityConstants.JwtConstants.ACCESS_TOKEN_EXPIRED_TIME));
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER, JSON.toJSONString(authUser));

        String accessToken = jwt.sign();

        AuthInfo authInfo = new AuthInfo();
        authInfo.setAccessToken(accessToken);
        authInfo.setRefreshToken(refreshToken);
        authInfo.setTokenPrefix(securityProperties.getToken().getPrefix());
        // 缓存认证信息-对应用户信息
        redisService.set(RedisConstant.Authorization.AUTHORIZATION_INFO + userEntity.getId(), authUser, RedisConstant.Authorization.AUTHORIZATION_INFO_CACHE_TIME);
        // 缓存认证信息-对应客户端访问令牌
        redisService.set(RedisConstant.Authorization.WEB_AUTHORIZATION_KEY + userEntity.getId(), accessToken, RedisConstant.Authorization.AUTHORIZATION_INFO_CACHE_TIME);
        // 缓存refreshToken
        redisService.set(RedisConstant.Authorization.REFRESH_TOKEN + userEntity.getId(), refreshToken, RedisConstant.Authorization.REFRESH_TOKEN_CACHE_TIME);

        return authInfo;
    }

    @Override
    public Boolean loginOut() {
        return true;
    }

    @Override
    public String refreshToken(String refreshToken) {
        JWT jwt = JWTUtil.parseToken(refreshToken);
        Object userID = jwt.getPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER_ID);
        Object o = redisService.get(RedisConstant.Authorization.REFRESH_TOKEN + userID);
        return "";
    }
}
