package org.github.bm.core.annotations;

import org.github.bm.common.constant.AppConstant;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.lang.annotation.*;

/**
 * 启动服务注解配置
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = AppConstant.BASE_PACKAGES)
public @interface BMCloudApplication {

}
