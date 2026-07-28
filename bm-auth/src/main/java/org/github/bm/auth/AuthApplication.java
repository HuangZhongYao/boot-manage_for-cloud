package org.github.bm.auth;

import org.github.bm.base.constant.ServiceEnum;
import org.github.bm.base.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

/**
 * Time 2025-07-28 16:36
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@BMCloudApplication
public class AuthApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_AUTH, AuthApplication.class, args);
    }
}
