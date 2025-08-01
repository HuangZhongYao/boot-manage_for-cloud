package org.github.bm.common.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Slf4j
public class SecurityContextHolder {

    private static final ThreadLocal<AuthUser> contextHolder = new ThreadLocal<AuthUser>();


    public static AuthUser getAuthUser() {
        AuthUser userContextHolder = contextHolder.get();
        if (userContextHolder == null) {
            // 从request中获取
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            AuthUser authUser = (AuthUser) requestAttributes.getAttribute(SecurityConstants.CONTEXT_HOLDER_USER_KEY, RequestAttributes.SCOPE_REQUEST);
            if (authUser != null) {
                contextHolder.set(authUser);
                return authUser;
            }
        }
        return userContextHolder;
    }

    public static Long getAuthUserId() {
        if (contextHolder.get() == null) {
            return null;
        }
        return contextHolder.get().getId();
    }

    public static void remove() {
        contextHolder.remove();
    }
}
