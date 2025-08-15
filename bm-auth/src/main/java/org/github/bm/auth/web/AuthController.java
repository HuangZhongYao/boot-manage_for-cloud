package org.github.bm.auth.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.auth.dto.LoginDTO;
import org.github.bm.auth.service.IAuthService;
import org.github.bm.auth.vo.AuthenticationUserDetailVO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.common.security.SecurityConstants;
import org.github.bm.system.vo.ResourcesTreeVo;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Time 2025-07-28 16:38
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "认证接口")
@RequestMapping("/auth")
@RestController
public class AuthController {

    @Resource
    IAuthService authService;

    @Operation(summary = "登录认证", description = "登录认证接口,认证成功后返回访问令牌")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "420", description = "账号或密码错误")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "430", description = "账号不存在")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "440", description = "该账户已被禁用")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "客户端错误")
    @PostMapping("/login")
    public ApiResponse<AuthInfo> login(
            @Validated @RequestBody LoginDTO loginDTO,
            @RequestHeader(name = SecurityConstants.BM_CLIENT_TYPE) String client) {
        return ApiResponse.ok(authService.login(loginDTO, client));
    }

    @Operation(summary = "注销登录")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "客户端错误")
    @GetMapping("/loginOut")
    public ApiResponse<Boolean> loginOut(@RequestHeader(name = SecurityConstants.BM_CLIENT_TYPE) String client) {
        return ApiResponse.ok(authService.loginOut(client));
    }

    @Operation(summary = "刷新令牌", description = "获取成功后原有refreshToken和accessToken都将失效")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "客户端错误")
    @GetMapping("/refreshToken")
    public ApiResponse<AuthInfo> refreshToken(
            @Parameter(name = SecurityConstants.REFRESH_AUTH_HEADER_KEY, required = true)
            @RequestHeader(name = SecurityConstants.REFRESH_AUTH_HEADER_KEY)
            String refreshToken,
            @RequestHeader(name = SecurityConstants.BM_CLIENT_TYPE)
            String client
    ) {
        return ApiResponse.ok(authService.refreshToken(refreshToken, client));
    }

    @GetMapping(value = "/queryPermissionsTree")
    @Operation(summary = "查询用户权限树", description = "查询用户权限,以树形结构返回")
    public ApiResponse<List<ResourcesTreeVo>> queryPermissionsTree() {
        return ApiResponse.ok(authService.queryPermissionsTree());
    }

    @Operation(summary = "获取验证码", description = "获取验证码")
    @GetMapping(value = "/captcha", produces = MediaType.TEXT_HTML_VALUE)
    public ApiResponse<String> captcha() {
        return ApiResponse.ok(authService.captcha());
    }

    @Operation(summary = "认证用户详情", description = "获取用户详情")
    @GetMapping(value = "/authenticationUserDetail")
    public ApiResponse<AuthenticationUserDetailVO> authenticationUserDetail() {
        return ApiResponse.ok(authService.authenticationUserDetail());
    }

}
