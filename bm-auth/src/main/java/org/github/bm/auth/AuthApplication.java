package org.github.bm.auth;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Time 2025-07-28 16:36
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@BMCloudApplication
public class AuthApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_AUTH.name, AuthApplication.class, args);
    }
}
