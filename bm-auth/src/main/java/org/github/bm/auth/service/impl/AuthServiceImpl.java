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
import org.github.bm.auth.vo.AuthenticationUserDetailVO;
import org.github.bm.common.base.response.ResponseCode;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.constant.RedisConstant;
import org.github.bm.common.enums.ClientEnum;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.common.prop.SecurityProperties;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.common.security.AuthUser;
import org.github.bm.common.security.SecurityConstants;
import org.github.bm.common.security.SecurityContextHolder;
import org.github.bm.common.util.ModelMapperUtil;
import org.github.bm.common.util.tree.ITreeNode;
import org.github.bm.common.util.tree.TreeUtil;
import org.github.bm.core.service.IRedisService;
import org.github.bm.system.converter.ResourcesConverter;
import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.feign.IResourcesClient;
import org.github.bm.system.feign.IRoleClient;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVo;
import org.github.bm.system.vo.RoleVO;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.IUserClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    IResourcesClient resourcesClient;
    @Resource
    IRoleClient roleClient;
    @Resource
    IAuthInfoConverter authInfoConverter;
    @Resource
    ResourcesConverter resourcesConverter;

    @Override
    public AuthInfo login(LoginDTO loginDTO, String client) {
        ClientEnum clientEnum = this.getClient(client);
        // 查询用户
        UserEntity userEntity = userClient.getUserByAccount(loginDTO.getAccount());
        if (userEntity == null) throw new UserFriendlyException("账号不存在", 430);
        if (!loginDTO.getPassword().equals("123456")) throw new UserFriendlyException("账号或密码错误", 420);
        if (userEntity.getEnable() == Boolean.FALSE) throw new UserFriendlyException("该账户已被禁用", 440);
        return this.generateJwt(userEntity, clientEnum);
    }

    @Override
    public Boolean loginOut(String client) {
        ClientEnum clientEnum = this.getClient(client);
        Long userId = SecurityContextHolder.getAuthUserId();
        redisService.del(RedisConstant.Authorization.clientAuthorizationCacheKey(clientEnum) + userId, RedisConstant.Authorization.clientRefreshTokenCacheKey(clientEnum) + userId);
        return true;
    }

    @Override
    public AuthInfo refreshToken(String refreshToken, String client) {
        ClientEnum clientEnum = this.getClient(client);
        Object userID;
        Object redisRefreshToken;
        String removePrefixRefreshToken;
        try {
            removePrefixRefreshToken = refreshToken.replaceAll(securityProperties.getToken().getPrefix(), "");
            // 解析refreshToken
            JWT jwt = JWTUtil.parseToken(removePrefixRefreshToken);
            // 获取用户ID
            userID = jwt.getPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER_ID);
            // 获取refreshToken过期时间
            redisRefreshToken = redisService.get(RedisConstant.Authorization.clientRefreshTokenCacheKey(clientEnum) + userID);
        } catch (Exception e) {
            throw new UserFriendlyException(ResponseCode.FAILED.message, ResponseCode.FAILED.code);
        }
        // 检查refreshToken是否过期
        if (refreshToken == null || removePrefixRefreshToken == null || redisRefreshToken == null)
            throw new UserFriendlyException(ResponseCode.LOGIN_EXPIRED.message, ResponseCode.LOGIN_EXPIRED.code);
        // 检查refreshToken与Redis中是否一致
        if (!removePrefixRefreshToken.equals(redisRefreshToken))
            throw new UserFriendlyException(ResponseCode.LOGIN_EXPIRED.message, ResponseCode.LOGIN_EXPIRED.code);

        UserEntity userEntity = userClient.getUserByID(userID.toString());
        return this.generateRefreshTokenJwt(userEntity, clientEnum);
    }

    @Override
    public List<ResourcesTreeVO> queryPermissionsTree() {
        // 当前用户id
        Long currentUserId = SecurityContextHolder.getAuthUserId();
        // 获取用户权限列表
        List<ResourcesEntity> resourcesVoList = this.resourcesClient.queryPermissionsListByUserId(currentUserId);
        // 转换成ResourcesTreeVo
        List<ResourcesTreeVO> resourcesTreeVOList = resourcesConverter.toResourcesTreeVoList(resourcesVoList);
        // 转换ITreeNode List
        List<ITreeNode<Long>> treeNodeList = new ArrayList<>(resourcesTreeVOList);
        // 转换成树结构
        List<ITreeNode<Long>> tree = TreeUtil.listToTree(treeNodeList);
        // 转换成ResourcesTreeVo 返回给前端
        return ModelMapperUtil.mapList(tree, ResourcesTreeVO.class);
    }


    @Override
    public String captcha() {
        return "";
    }

    @Override
    public AuthenticationUserDetailVO authenticationUserDetail() {
        // 当前用户Id
        Long currentUserId = SecurityContextHolder.getAuthUserId();
        // 查询当前用户
        AuthenticationUserDetailVO vo = ModelMapperUtil.map(userClient.getUserByID(currentUserId), AuthenticationUserDetailVO.class);
        // 用户角色列表
        List<RoleVO> roles = roleClient.getRoleVoByUserId(currentUserId);
        // 资源权限列表
        List<ResourcesVo> permissions = this.resourcesClient.queryPermissionsVoListByUserId(currentUserId);
        // 组装角色
        vo.setRoles(roles);
        // 组装权限
        vo.setPermissions(permissions);
        return vo;
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
        JWT jwt = this.buildJWT(userEntity.getId());
        // 生成refreshToken
        String refreshToken = jwt.sign();
        // 构建accessToken payload
        AuthUser authUser = new AuthUser(userEntity.getId(), userEntity.getUsername(), userEntity.getAccount(), userEntity.getPhone(), userEntity.getEnable());
        // 设置accessToken payload
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER, JSON.toJSONString(authUser));
        // 生成accessToken
        String accessToken = jwt.sign();
        // 缓存认证信息-对应用户信息
        redisService.set(RedisConstant.Authorization.AUTHORIZATION_INFO + userEntity.getId(), authUser, RedisConstant.Authorization.AUTHORIZATION_INFO_CACHE_TIME);
        // 缓存认证信息-对应客户端访问令牌
        redisService.set(RedisConstant.Authorization.clientAuthorizationCacheKey(clientEnum) + userEntity.getId(), accessToken, RedisConstant.Authorization.ACCESS_TOKEN_CACHE_TIME);
        // 缓存refreshToken
        redisService.set(RedisConstant.Authorization.clientRefreshTokenCacheKey(clientEnum) + userEntity.getId(), refreshToken, RedisConstant.Authorization.REFRESH_TOKEN_CACHE_TIME);
        // 访问令牌过期时间
        DateTime accessTokenExpiresAt = DateUtil.offsetSecond(now, (int) RedisConstant.Authorization.ACCESS_TOKEN_CACHE_TIME);
        // 刷新令牌过期时间
        DateTime refreshTokenExpiresAt = DateUtil.offsetSecond(now, (int) RedisConstant.Authorization.REFRESH_TOKEN_CACHE_TIME);

        AuthInfo authInfo = authInfoConverter.toAuthInfo(userEntity);
        authInfo.setAccessToken(accessToken);
        authInfo.setRefreshToken(refreshToken);
        authInfo.setTokenPrefix(securityProperties.getToken().getPrefix());
        authInfo.setAccessTokenExpiresIn(accessTokenExpiresAt);
        authInfo.setRefreshTokenExpiresIn(refreshTokenExpiresAt);
        return authInfo;
    }

    private AuthInfo generateRefreshTokenJwt(UserEntity userEntity, ClientEnum clientEnum) {
        // 当前时间
        Date now = new Date();
        // 构建jwt对象
        JWT jwt = this.buildJWT(userEntity.getId());
        // 构建accessToken payload
        AuthUser authUser = new AuthUser(userEntity.getId(), userEntity.getUsername(), userEntity.getAccount(), userEntity.getPhone(), userEntity.getEnable());
        // 设置accessToken payload
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER, JSON.toJSONString(authUser));
        // 生成accessToken
        String accessToken = jwt.sign();
        // 缓存认证信息-对应客户端访问令牌
        redisService.set(RedisConstant.Authorization.clientAuthorizationCacheKey(clientEnum) + userEntity.getId(), accessToken, RedisConstant.Authorization.ACCESS_TOKEN_CACHE_TIME);
        // 访问令牌过期时间
        DateTime accessTokenExpiresAt = DateUtil.offsetSecond(now, (int) RedisConstant.Authorization.ACCESS_TOKEN_CACHE_TIME);
        AuthInfo authInfo = authInfoConverter.toAuthInfo(userEntity);
        authInfo.setAccessToken(accessToken);
        authInfo.setTokenPrefix(securityProperties.getToken().getPrefix());
        authInfo.setAccessTokenExpiresIn(accessTokenExpiresAt);
        return authInfo;
    }

    private JWT buildJWT(Long userId) {
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
        // 添加payload存放用户id
        jwt.setPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER_ID, userId);
        return jwt;
    }

    private ClientEnum getClient(String client) {
        if (client == null) throw new UserFriendlyException("客户端错误", 450);
        for (ClientEnum value : ClientEnum.values()) {
            if (value.code.equals(client.toUpperCase())) {
                return value;
            }
        }
        throw new UserFriendlyException("客户端错误", 450);
    }
}
