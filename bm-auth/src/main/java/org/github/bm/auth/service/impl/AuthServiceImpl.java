package org.github.bm.auth.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.auth.converter.IAuthInfoConverter;
import org.github.bm.auth.dto.LoginDTO;
import org.github.bm.auth.service.IAuthService;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.constant.RedisConstant;
import org.github.bm.common.enums.ClientEnum;
import org.github.bm.common.exception.UserFriendlyException;
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
    @Resource
    IAuthInfoConverter authInfoConverter;

    @Override
    public AuthInfo login(LoginDTO loginDTO, String client) {
        ClientEnum clientEnum = this.getClient(client);
        // 查询用户
        UserEntity userEntity = userClient.getUserByAccount(loginDTO.getAccount());
        if (userEntity == null) throw new UserFriendlyException("账号不存在", 430);
        if (!loginDTO.getPassword().equals("123456")) throw new UserFriendlyException("账号或密码错误", 420);
        if (!userEntity.getEnable()) throw new UserFriendlyException("该账户已被禁用", 440);
        return this.generateJwt(userEntity, clientEnum);
    }

    @Override
    public Boolean loginOut(String client) {
        ClientEnum clientEnum = this.getClient(client);
        return true;
    }

    @Override
    public AuthInfo refreshToken(String refreshToken, String client) {
        ClientEnum clientEnum = this.getClient(client);
        JWT jwt = JWTUtil.parseToken(refreshToken);
        Object userID = jwt.getPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER_ID);
        Long ttl = redisService.getExpire(RedisConstant.Authorization.clientRefreshTokenCacheKey(clientEnum) + userID);
        UserEntity userEntity = userClient.getUserByID(userID.toString());
        return this.generateJwt(userEntity, clientEnum);
    }

    /**
     * 生成jwt
     *
     * @param userEntity 用户信息
     * @param clientEnum {@link ClientEnum 客户端}
     * @return AuthInfo
     */
    private AuthInfo generateJwt(UserEntity userEntity, ClientEnum clientEnum) {
        // 当前时间
        Date now = new Date();
        // 构建jwt对象
        JWT jwt = new JWT();
        // 签发时间
        jwt.setIssuedAt(now);
        // 签发者
        jwt.setIssuer(AppConstant.BASE_PACKAGES);
        // 密钥
        jwt.setKey(securityProperties.getToken().getSecret().getBytes());
        // 过期时间
        jwt.setExpiresAt(DateUtil.offsetDay(now, SecurityConstants.JwtConstants.REFRESH_TOKEN_EXPIRED_TIME));
        // 添加payload,refreshToken payload 只存放用户id
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER_ID, userEntity.getId());
        // 生成refreshToken
        String refreshToken = jwt.sign();

        // 构建accessToken payload
        AuthUser authUser = new AuthUser(userEntity.getId(), userEntity.getUsername(), userEntity.getAccount(), userEntity.getPhone(), userEntity.getEnable());
        // 访问令牌过期时间
        DateTime accessTokenExpiresAt = DateUtil.offsetHour(now, SecurityConstants.JwtConstants.ACCESS_TOKEN_EXPIRED_TIME);
        // 设置accessToken访问令牌过期时间
        jwt.setExpiresAt(accessTokenExpiresAt);
        // 设置accessToken payload
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER, JSON.toJSONString(authUser));
        // 生成accessToken
        String accessToken = jwt.sign();

        // 缓存认证信息-对应用户信息
        redisService.set(RedisConstant.Authorization.AUTHORIZATION_INFO + userEntity.getId(), authUser, RedisConstant.Authorization.AUTHORIZATION_INFO_CACHE_TIME);
        // 缓存认证信息-对应客户端访问令牌
        redisService.set(RedisConstant.Authorization.clientAuthorizationCacheKey(clientEnum) + userEntity.getId(), accessToken, RedisConstant.Authorization.AUTHORIZATION_INFO_CACHE_TIME);
        // 缓存refreshToken
        redisService.set(RedisConstant.Authorization.clientRefreshTokenCacheKey(clientEnum) + userEntity.getId(), refreshToken, RedisConstant.Authorization.REFRESH_TOKEN_CACHE_TIME);

        AuthInfo authInfo = authInfoConverter.toAuthInfo(userEntity);
        authInfo.setAccessToken(accessToken);
        authInfo.setRefreshToken(refreshToken);
        authInfo.setTokenPrefix(securityProperties.getToken().getPrefix());
        authInfo.setExpiresIn(accessTokenExpiresAt);
        return authInfo;
    }

    private ClientEnum getClient(String client) {
        for (ClientEnum value : ClientEnum.values()) {
            if (value.code.equals(client)) {
                return value;
            }
        }
        throw new UserFriendlyException("客户端错误", 430);
    }
}
