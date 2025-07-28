package org.github.bm.common.launch;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.constant.LauncherConstant;
import org.github.bm.common.constant.NacosConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * 项目启动器，指定环境变量
 */
public class BMApplication {
    /**
     * @param appName       应用名 AppConstant中定义
     * @param primarySource 启动类
     * @param args          启动参数
     * @return ConfigurableApplicationContext 启动后的上下文
     */
    public static ConfigurableApplicationContext run(String appName, Class<?> primarySource, String... args) {
        Properties props = System.getProperties();
        String startJarPath = BMApplication.class.getResource("/").getPath().split("!")[0];
        String env = getEnv(props.getProperty("spring.profiles.active"));
        System.out.printf("----启动中，读取到的环境变量:[%s]，jar地址:[%s]----%n", env, startJarPath);
        setProperty(props, "info.version", AppConstant.APPLICATION_VERSION);
        setProperty(props, "spring.application.name", appName);
        setProperty(props, "spring.profiles.active", env);
        setProperty(props, "spring.cloud.nacos.discovery.server-addr", LauncherConstant.nacosAddr(env));
        setProperty(props, "spring.cloud.nacos.config.server-addr", LauncherConstant.nacosAddr(env));
        setProperty(props, "spring.config.import", "nacos:" + NacosConstant.dataId(appName));
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
        return SpringApplication.run(primarySource, args);
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
