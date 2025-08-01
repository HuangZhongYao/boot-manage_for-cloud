package org.github.bm.gateway;


import org.springframework.util.AntPathMatcher;

import java.util.List;

/**
 * Time 2025-08-01 15:31
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */

public class Main {
    static AntPathMatcher matcher = new AntPathMatcher();

    public static void main(String[] args) {
        System.out.println(matcher.match("/**", "/bm/api/v1/user/login"));
        System.out.println(matcher.match("/bm/api/v1/user/login", "/bm/api/v1/user/login"));
        System.out.println(matcher.match("/**/api/v1/**", "/bm/api/v1/user/login"));
        System.out.println(matcher.match("/**/api/v3", "/bm/api/v3/user/login"));
        System.out.println(matcher.match("/**/api/v3", "/bm/api/v3"));
        System.out.println(matcher.match("/**/api/v3/**/login", "/bm/api/v3/user/login"));

        boolean b = List.of("/bm-auth/auth/demoLogin", "/**/v3/api-docs")
                .stream()
                .anyMatch(skipUrl -> {
                    boolean match = matcher.match(skipUrl, "/bm-auth/auth/demoLogin");
                    System.out.println(skipUrl + ":" + match);
                    return match;
                });
        System.out.println("b = " + b);
    }
}
