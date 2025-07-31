package org.github.bm.user;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@BMCloudApplication
public class UserApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_USER.name, UserApplication.class, args);
    }
}
