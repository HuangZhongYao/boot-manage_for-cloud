package org.github.bm.user;

import org.github.bm.base.constant.ServiceEnum;
import org.github.bm.base.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

@BMCloudApplication
public class UserApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_USER, UserApplication.class, args);
    }
}
