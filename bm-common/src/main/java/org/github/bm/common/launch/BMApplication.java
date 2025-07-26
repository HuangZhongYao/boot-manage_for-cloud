package org.github.bm.common.launch;

import org.github.bm.common.constant.AppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

/**
 * 项目启动器，指定环境变量
 */
public class BMApplication {
    public static ConfigurableApplicationContext run(String appName,Class<?> primarySource, String... args) {
        System.out.printf("----启动中，读取到的环境变量:[%s]，jar地址:[%s]----%n", "dev", "/usr/app.jar");
        Properties props = System.getProperties();
        props.setProperty("info.version", AppConstant.APPLICATION_VERSION);
        props.setProperty("spring.application.name", appName);
        return SpringApplication.run(primarySource, args);
    }

}
