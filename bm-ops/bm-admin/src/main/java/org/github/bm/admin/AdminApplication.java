package org.github.bm.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_ADMIN.name, AdminApplication.class, args);
    }
}
