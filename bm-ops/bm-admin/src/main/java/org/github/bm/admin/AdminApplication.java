package org.github.bm.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_ADMIN_NAME, AdminApplication.class, args);
    }
}
