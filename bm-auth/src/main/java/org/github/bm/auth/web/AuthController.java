package org.github.bm.auth.web;

import com.alibaba.fastjson2.JSON;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.auth.service.IAuthService;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.common.security.SecurityContextHolder;
import org.github.bm.core.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Time 2025-07-28 16:38
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "认证接口")
@RequestMapping("/auth")
@RestController
public class AuthController {

    @Resource
    RedisService redisService;
    @Resource
    IAuthService authService;

    @Operation(summary = "登录认证")
    @GetMapping("/login")
    public ApiResponse<AuthInfo> auth(@RequestParam(value = "id", required = true) String id) {
        return ApiResponse.ok(authService.login());
    }

    @Operation(summary = "注销登录")
    @GetMapping("/loginOut")
    public ApiResponse<Boolean> loginOut() {
        return ApiResponse.ok(authService.loginOut());
    }

    @Operation(summary = "sys接口")
    @GetMapping("/sys")
    public ApiResponse<Properties> sys() {
        throw new UserFriendlyException("操作错误了，请不要调用这个接口");
//        return ApiResponse.ok(System.getProperties());
    }

    @Operation(summary = "date接口")
    @GetMapping("/date")
    public ApiResponse<Map<String, Object>> map() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", new Date());
        map.put("datelocal", LocalDateTime.now());
        map.put("authUser", SecurityContextHolder.getAuthUser());
        return ApiResponse.ok(map);
    }

    @Operation(summary = "redis接口")
    @GetMapping("/redis")
    public ApiResponse<String> redis() {
        redisService.set("redis", "redis");
        redisService.hset("redis-hash", "hash-k", "hash-v");
        redisService.hset("redis-hash", "hash-k1", JSON.toJSONString(System.getenv()));
        return ApiResponse.ok(redisService.get("redis").toString());
    }

}
