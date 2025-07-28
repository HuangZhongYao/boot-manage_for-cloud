package org.github.bm.swagger;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_SWAGGER_NAME, SwaggerApplication.class, args);
    }
}
