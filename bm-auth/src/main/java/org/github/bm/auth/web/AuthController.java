package org.github.bm.auth.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.github.bm.common.base.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * Time 2025-07-28 16:38
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "认证接口")
@RequestMapping("/auth")
@RestController
public class AuthController {

    @Operation(summary = "认证接口")
    @GetMapping("/demoLogin")
    public String auth() {
        return "auth";
    }
    @Operation(summary = "认证接口")
    @GetMapping("/sys")
    public ApiResponse<Properties> sys() {
        return ApiResponse.ok(System.getProperties());
    }

}
