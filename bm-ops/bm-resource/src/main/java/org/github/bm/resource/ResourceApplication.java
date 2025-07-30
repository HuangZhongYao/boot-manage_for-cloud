package org.github.bm.resource;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

@BMCloudApplication
public class ResourceApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_RESOURCE_NAME, ResourceApplication.class, args);
    }
}
