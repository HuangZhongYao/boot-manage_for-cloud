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

        String path = "/bm-auth/auth/login";
        // 去掉第一级路径
        String pathWithoutFirstLevel = path.replaceAll("^/[^/]+/", "/");

        System.out.println("pathWithoutFirstLevel = " + pathWithoutFirstLevel);
        System.out.println("m = " + "/doc.html".replaceAll("^/[^/]+/", "/"));
        System.out.println("m = " + "/v3/doc.html".replaceAll("^/[^/]+/", "/"));
        System.out.println("m = " + "/bm-auth/auth/login".replaceAll("^/[^/]+/", "/"));
        System.out.println("m = " + "/admin/dashboard".replaceAll("^/[^/]+/", "/"));
        System.out.println("m = " + "/webjars/".replaceAll("^/[^/]+/", "/"));
        boolean matched = matcher.match("/webjars/**", "/webjars/erieu/a.jar");
        System.out.println("matched = " + matched);


        System.out.println(matcher.match("/**", "/bm/api/v1/user/login"));
        System.out.println(matcher.match("/bm/api/v1/user/login", "/bm/api/v1/user/login"));
        System.out.println(matcher.match("/**/api/v1/**", "/bm/api/v1/user/login"));
        System.out.println(matcher.match("/**/api/v3", "/bm/api/v3/user/login"));
        System.out.println(matcher.match("/**/api/v3", "/bm/api/v3"));
        System.out.println(matcher.match("/**/api/v3/**/login", "/bm/api/v3/user/login"));

         List.of("/bm-auth/auth/demoLogin", "/**/v3/api-docs")
                .stream()
                .forEach(skipUrl -> {
                    boolean match = matcher.match(skipUrl, "/bm-auth/auth/demoLogin");
                    System.out.println(skipUrl + ":" + match);
                });
    }
}
