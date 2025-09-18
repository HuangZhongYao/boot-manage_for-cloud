package org.github.bm.system;

import org.github.bm.common.constant.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

@BMCloudApplication
public class SystemApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_SYSTEM, SystemApplication.class, args);
    }
}
