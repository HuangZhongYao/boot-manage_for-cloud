package org.github.system;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_SYSTEM_NAME, SystemApplication.class, args);
    }
}
