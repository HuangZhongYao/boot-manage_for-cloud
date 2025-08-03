package org.github.bm.core.knife4j;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.github.bm.common.base.response.ResponseCode;
import org.github.bm.common.security.SecurityConstants;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger配置类
 *
 * @Desc
 * @Time 2024-07-11 16:23
 * @Author HuangZhongYao
 */
@SecurityScheme(name = SecurityConstants.AUTH_HEADER_KEY, type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER, description = "JWT Bearer Token 认证", scheme = "token")
@OpenAPIDefinition(info = @Info(title = "Boot-Manage 后台管理系统微服务版 API文档", description = "Boot-Manage后台管理系统中 所涉及的API文档的详细描述", termsOfService = "https://github.com/HuangZhongYao", license = @License(name = "许可证名称", url = "http://example.com/license"), contact = @Contact(name = "Github-zuuuYao", url = "https://github.com/HuangZhongYao/boot-manage_for-cloud", email = "176853006043@163.com")))
@Configuration
public class Knife4jSwaggerConfiguration {

    /**
     * 全局自定义扩展
     */
    @Bean
    public GlobalOpenApiCustomizer globalOpenApiCustomizer() {
        return openApi -> {
            // 全局添加Authorization
            if (openApi.getPaths() != null) {
                openApi.getPaths().forEach((path, pathItem) -> {
                    // 其他接口统一添加令牌header key
                    pathItem.readOperations().forEach(operation -> {
                        // 添加令牌header key TODO可以排除 SecurityProperties.skipUrl 中的接口
                        operation.addSecurityItem(new SecurityRequirement().addList(SecurityConstants.AUTH_HEADER_KEY));
                        // 设置全局响应码 TODO可以排除 SecurityProperties.skipUrl 中的接口
                        operation.getResponses()
                                .addApiResponse(ResponseCode.OK.code + "", new ApiResponse().description(ResponseCode.OK.message))
                                .addApiResponse(ResponseCode.REQUEST_FAILED.code + "", new ApiResponse().description(ResponseCode.REQUEST_FAILED.message))
                                .addApiResponse(ResponseCode.NOT_LOGIN.code + "", new ApiResponse().description(ResponseCode.NOT_LOGIN.message))
                                .addApiResponse(ResponseCode.LOGIN_EXPIRED.code + "", new ApiResponse().description(ResponseCode.LOGIN_EXPIRED.message))
                                .addApiResponse(ResponseCode.NO_PERMISSION.code + "", new ApiResponse().description(ResponseCode.NO_PERMISSION.message))
                                .addApiResponse(ResponseCode.REQUEST_METHOD_NOT_FOUND.code + "", new ApiResponse().description(ResponseCode.REQUEST_METHOD_NOT_FOUND.message))
                                .addApiResponse(ResponseCode.VALIDATION_FAILED.code + "", new ApiResponse().description(ResponseCode.VALIDATION_FAILED.message))
                                .addApiResponse(ResponseCode.FAILED.code + "", new ApiResponse().description(ResponseCode.FAILED.message));

                    });
                });
            }
        };
    }

}
