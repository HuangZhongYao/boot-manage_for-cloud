package org.github.bm.core.feign;

import cn.hutool.core.util.StrUtil;
import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * feign拦截器
 */
@Slf4j
@Configuration
public class FeignConfiguration {

    @Value("${spring.application.name}")
    private String appName;


    @Bean(name = "feignRequestInterceptor")
    public RequestInterceptor feignRequestInterceptor() {
        log.info("注册Feign拦截器...");
        return template -> {
            // 获取请求
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (null != requestAttributes) {
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
                HttpServletRequest request = servletRequestAttributes.getRequest();
                // 透传请求源
                String source = request.getHeader(SecurityConstants.REQUEST_SOURCE);
                source = StrUtil.isNotBlank(source) ? source + " -> " + appName : appName;
                template.header(SecurityConstants.REQUEST_SOURCE, source);
                // 透传请求源path
                String sourcePath = request.getHeader(SecurityConstants.REQUEST_SOURCE_PATH);
                template.header(SecurityConstants.REQUEST_SOURCE_PATH, sourcePath);
                // 透传请求上下文
                String authorizationContextHolder = request.getHeader(SecurityConstants.GATEWAY_AUTHORIZATION_CONTEXT_HOLDER_KEY);
                if (authorizationContextHolder != null) {
                    template.header(SecurityConstants.GATEWAY_AUTHORIZATION_CONTEXT_HOLDER_KEY, authorizationContextHolder);
                }
            }
        };
    }
}
