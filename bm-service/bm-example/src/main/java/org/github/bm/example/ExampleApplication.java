package org.github.bm.example;

import org.github.bm.common.constant.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

@BMCloudApplication
public class ExampleApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_EXAMPLE.name, ExampleApplication.class, args);
    }
}
