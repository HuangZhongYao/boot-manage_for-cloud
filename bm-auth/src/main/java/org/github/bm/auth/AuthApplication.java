package org.github.bm.auth;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Time 2025-07-28 16:36
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@SpringBootApplication(scanBasePackages = "org.github.bm")
public class AuthApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_AUTH_NAME, AuthApplication.class, args);
    }
}
