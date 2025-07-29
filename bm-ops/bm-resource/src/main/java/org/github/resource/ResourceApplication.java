package org.github.resource;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourceApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_RESOURCE_NAME, ResourceApplication.class, args);
    }
}
