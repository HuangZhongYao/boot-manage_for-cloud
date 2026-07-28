package org.github.bm.resource;

import org.github.bm.base.constant.ServiceEnum;
import org.github.bm.base.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

@BMCloudApplication
public class ResourceApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_RESOURCE, ResourceApplication.class, args);
    }
}
