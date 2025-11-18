package org.github.bm.example.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.github.bm.common.base.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示使用Sentinel限流
 * Time 2025-11-11 11:02
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "演示Sentinel限流")
@RestController
@RequestMapping("/test/sentinel/")
@RequiredArgsConstructor
public class ExampleSentinelController {

    /**
     * 限流测试接口：正常响应，仅通过QPS阈值触发限流
     * 资源名：flowLimitResource  (Sentinel 控制台 配置限流规则需要使用资源名)
     */
    @Operation(summary = "限流测试接口")
    @SentinelResource(
            value = "flowLimitResource"
            //blockHandler = "flowBlockHandler"  限流触发时的处理方法,因为GlobalErrorController中全局处理了这里不单独指定异常处理方法
    )
    @GetMapping(value = "/flow/demo")
    public ApiResponse<String> flowLimitTest(@RequestParam("id") String id) {
        // 接口本身无异常，仅当QPS超过阈值时触发限流
        return ApiResponse.ok("限流接口正常响应：" + id);
    }

    /**
     * 熔断测试接口
     * 熔断资源名：degradeTest
     */
    @Operation(summary = "熔断测试接口")
    @SentinelResource(
            value = "degradeTest"
            //blockHandler = "degradeBlockHandler"  限流触发时的处理方法,因为GlobalErrorController中全局处理了这里不单独指定异常处理方法
    )
    @GetMapping(value = "/degrade/demo")
    public ApiResponse<String> degradeTest() {
        // 规则内异常数超过阈值时触发熔断
        throw new RuntimeException("熔断测试接口异常");
    }


}
