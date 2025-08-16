package org.github.bm.resource.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.resource.util.LocalStorageUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置类
 *
 * @Desc WebMvc配置类
 * @Time 2024-07-11 16:23
 * @Author HuangZhongYao
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class WebMvcStaticResourcesConfiguration implements WebMvcConfigurer {
    private final StorageProperties storageProperties;

    public static final String LOCAL_STORAGE_RESOURCE_PATH = "/localStorage/";

    /**
     * 配置静态资源的处理规则
     *
     * @param registry
     */
    @SneakyThrows
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("配置本地存储资源目录...");
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 本地存储资源目录
        registry.addResourceHandler(LOCAL_STORAGE_RESOURCE_PATH + "**")
                .addResourceLocations("file:" + LocalStorageUtil.getRootPath(storageProperties.getBucketName()) + "/");
    }


}
