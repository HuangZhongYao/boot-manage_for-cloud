package org.github.bm.auth.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
