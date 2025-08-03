package org.github.bm.core.filter;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.base.response.ErrorResponse;
import org.github.bm.common.base.response.ResponseCode;
import org.github.bm.common.prop.SecurityProperties;
import org.github.bm.common.security.AuthUser;
import org.github.bm.common.security.SecurityConstants;
import org.github.bm.common.security.SecurityContextHolder;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Time 2025-08-01 10:53
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Slf4j
@Component
public class RequestFilter extends OncePerRequestFilter implements Ordered {

    @Resource
    SecurityProperties securityProperties;


    /**
     * 匹配器
     */
    private final AntPathMatcher matcher = new AntPathMatcher();

    public RequestFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {

            // 解析请求用户上下文信息
            String authorizationContextHolder = request.getHeader(SecurityConstants.GATEWAY_AUTHORIZATION_CONTEXT_HOLDER_KEY);
            if (authorizationContextHolder != null) {
                AuthUser authUser = JSON.parseObject(authorizationContextHolder, AuthUser.class);
                request.setAttribute(SecurityConstants.CONTEXT_HOLDER_USER_KEY, authUser);
            }

            // 获取请求路径
            String path = request.getRequestURI();
            // 获取原始路径
            String sourcePath = request.getHeader(SecurityConstants.REQUEST_SOURCE_PATH);
            // 是否放行路径支持原始路径匹配; 列子：认证服务的登录请求放行那登录请求触发的调用下游服务也放行
            if (isSkip(path) || isSkip(sourcePath)) {
                filterChain.doFilter(request, response);
                return;
            }

            // 内部调用认证
            if (securityProperties.getInternalValid() != null && securityProperties.getInternalValid().getEnable()) {
                // 获取内部调用认证的token
                String internalToken = request.getHeader(SecurityConstants.GATEWAY_AUTHORIZATION_KEY);
                // 验证内部调用token
                if (!securityProperties.getInternalValid().getToken().equals(internalToken)) {
                    log.warn(path + " " + ResponseCode.ILLEGAL_REQUEST.message);
                    this.buildErrorResponse(response, path, ResponseCode.ILLEGAL_REQUEST.message);
                    return;
                }
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 清空 SecurityContextHolder
            SecurityContextHolder.remove();
        }
    }

    private void buildErrorResponse(HttpServletResponse response, String path, String msg) throws IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setStatus(ResponseCode.ILLEGAL_REQUEST.code);
        response.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(new ErrorResponse(msg, path, false)));
        writer.flush();
        writer.close();
    }

    private boolean isSkip(String path) {
        return SecurityConstants.DEFAULT_EXCLUDE_PATTERNS
                .stream()
                .anyMatch(skipUrl -> matcher.match(skipUrl, path))
                ||
                securityProperties.getSkipUrl()
                        .stream()
                        .anyMatch(skipUrl -> matcher.match(skipUrl, path));
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
