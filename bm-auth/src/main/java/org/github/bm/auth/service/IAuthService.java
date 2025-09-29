package org.github.bm.auth.service;

import org.github.bm.auth.dto.LoginDTO;
import org.github.bm.auth.vo.AuthenticationUserDetailVO;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.system.vo.ResourcesTreeVO;

import java.util.List;

/**
 * 认证服务接口
 *
 * 定义了用户认证相关的核心功能，包括登录、登出、令牌刷新、权限查询等操作
 */
public interface IAuthService {
    /**
     * 用户登录认证
     *
     * @param loginDTO 登录信息传输对象，包含账号、密码等信息
     * @param client 客户端类型标识
     * @return AuthInfo 认证信息，包含访问令牌和刷新令牌
     */
    AuthInfo login(LoginDTO loginDTO, String client);

    /**
     * 用户登出
     *
     * @param client 客户端类型标识
     * @return Boolean 登出操作是否成功
     */
    Boolean loginOut(String client);

    /**
     * 刷新访问令牌
     *
     * @param refreshToken 刷新令牌
     * @param client 客户端类型标识
     * @return AuthInfo 新的认证信息
     */
    AuthInfo refreshToken(String refreshToken, String client);

    /**
     * 查询用户权限树
     *
     * @return List<ResourcesTreeVO> 权限资源树列表
     */
    List<ResourcesTreeVO> queryPermissionsTree();

    /**
     * 生成验证码
     *
     * @return String 验证码字符串
     */
    String captcha();

    /**
     * 获取认证用户详细信息
     *
     * @return AuthenticationUserDetailVO 认证用户的详细信息
     */
    AuthenticationUserDetailVO authenticationUserDetail();
}

