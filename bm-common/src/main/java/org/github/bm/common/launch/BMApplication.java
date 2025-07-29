package org.github.bm.common.launch;

import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.constant.AppConstant;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * 项目启动器，指定环境变量
 */
@Slf4j
public class BMApplication {
    /**
     * @param appName       应用名 AppConstant中定义
     * @param primarySource 启动类
     * @param args          启动参数
     * @return ConfigurableApplicationContext 启动后的上下文
     */
    public static ConfigurableApplicationContext run(String appName, Class<?> primarySource, String... args) {
        // 读取环境变量，使用spring boot的规则
        ConfigurableEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new SimpleCommandLinePropertySource(args));
        propertySources.addLast(new MapPropertySource(StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME, environment.getSystemProperties()));
        propertySources.addLast(new SystemEnvironmentPropertySource(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, environment.getSystemEnvironment()));
        // 设置环境变量读取nacos配置、注册服务、sentinel、seata
        Properties props = System.getProperties();
        String startJarPath = BMApplication.class.getResource("/").getPath().split("!")[0];
        String env = getEnv(props.getProperty("spring.profiles.active"));
        System.out.printf("----启动中，读取到的环境变量:[%s]，jar地址:[%s]----%n", env, startJarPath);
        setProperty(props, "info.version", AppConstant.APPLICATION_VERSION);
        setProperty(props, "spring.application.name", appName);
        setProperty(props, "spring.profiles.active", env);
        setProperty(props, "spring.cloud.nacos.discovery.server-addr", LauncherConstant.nacosAddr(env));
        setProperty(props, "spring.cloud.nacos.config.server-addr", LauncherConstant.nacosAddr(env));
        setProperty(props, "spring.config.import[0]", "nacos:" + NacosConstant.dataId(NacosConstant.NACOS_CONFIG_PREFIX));// 公共配置
        setProperty(props, "spring.config.import[1]", "nacos:" + NacosConstant.dataId(appName));// 当前服务配置
        setProperty(props, "spring.cloud.nacos.config.namespace", LauncherConstant.NACOS_NAMESPACE);// 设置nacos配置中心命名空间
        setProperty(props, "spring.cloud.nacos.config.refresh-enabled", NacosConstant.NACOS_CONFIG_REFRESH);
        setProperty(props, "spring.cloud.nacos.config.prefix", NacosConstant.NACOS_CONFIG_PREFIX);
        setProperty(props, "spring.cloud.nacos.config.file-extension", NacosConstant.NACOS_CONFIG_FORMAT);
        setProperty(props, "spring.cloud.nacos.config.import-check.enabled", "false");
        setProperty(props, "spring.cloud.nacos.config.file-extension", NacosConstant.NACOS_CONFIG_FORMAT);
        setProperty(props, "spring.cloud.nacos.config.group", NacosConstant.NACOS_CONFIG_GROUP);
        setProperty(props, "spring.cloud.nacos.discovery.group", NacosConstant.NACOS_CONFIG_GROUP);
        setProperty(props, "spring.cloud.sentinel.transport.dashboard", LauncherConstant.sentinelAddr(env));
        setProperty(props, "spring.cloud.alibaba.seata.tx-service-group", appName.concat(NacosConstant.NACOS_GROUP_SUFFIX));

        // 构建Springboot启动器
        SpringApplicationBuilder builder = new SpringApplicationBuilder(primarySource);
        // 添加自定义配置类来设置扫描包
        builder.sources(new Object() {
            @Configuration
            @ComponentScan(basePackages = {AppConstant.BASE_PACKAGES})
            static class CustomScanConfig {
            }
        }.getClass());
        // 添加监听器
        builder.listeners((WebServerInitializedEvent event) -> {
            int localPort = event.getWebServer().getPort();
            log.info("---[{}]---启动完成，当前使用的端口:[{}]，环境变量:[{}]---", appName.toUpperCase(), localPort, env);
        });
        return builder.run(args);
    }

    /**
     * 设置环境变量
     *
     * @param props 环境变量
     * @param key   属性名
     * @param value 属性值
     */
    public static void setProperty(Properties props, String key, String value) {
        if (StringUtils.isEmpty(props.getProperty(key))) {
            props.setProperty(key, value);
        }
    }

    /**
     * 获取激活环境
     *
     * @param profile 激活环境
     * @return 环境
     */
    public static String getEnv(String profile) {
        if (null == profile) {
            System.out.printf("----未设置环境变量,已使用默认环境:[%s]\n", AppConstant.DEV_CODE);
            return AppConstant.DEV_CODE;
        }
        return profile;
    }
}
