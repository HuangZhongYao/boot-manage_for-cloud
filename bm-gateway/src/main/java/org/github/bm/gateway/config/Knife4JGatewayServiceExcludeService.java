package org.github.bm.gateway.config;

import com.github.xiaoymin.knife4j.spring.gateway.Knife4jGatewayProperties;
import com.github.xiaoymin.knife4j.spring.gateway.discover.spi.GatewayServiceExcludeService;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.constant.AppConstant;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 聚合文档排除服务配置
 * Time 2025-07-31 10:41
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */

@Slf4j
@Component
public class Knife4JGatewayServiceExcludeService implements GatewayServiceExcludeService {
    /**
     * 聚合文档排除不以{@link org.github.bm.common.constant.AppConstant#APPLICATION_NAME_PREFIX}开头命名的服务和配置文件excluded-services中的服务
     *
     * @param environment 当前环境变量
     * @param properties  Knife4j网关聚合配置信息
     * @param services    微服务注册中心中所有子服务
     * @return 排除的服务名称集合
     */
    @Override
    public Set<String> exclude(Environment environment, Knife4jGatewayProperties properties, List<String> services) {
        // 获取服务发现配置信息
        Knife4jGatewayProperties.Discover discover = properties.getDiscover();
        // 排除服务
        Set<String> excludeService = services.stream().filter(serviceName -> discover.getExcludedServices().contains(serviceName) || !serviceName.startsWith(AppConstant.APPLICATION_NAME_PREFIX)).collect(Collectors.toSet());
        // 获取聚合文档服务配置信息
        Map<String, Knife4jGatewayProperties.ServiceConfigInfo> serviceConfig = discover.getServiceConfig();
        // 设置聚合文档中的服务名称
        AppConstant.SERVICES.forEach(serviceEnum -> {
            if (!excludeService.contains(serviceEnum.name)) {
                // 获取服务信息没有则创建
                Knife4jGatewayProperties.ServiceConfigInfo serviceConfigInfo = serviceConfig.computeIfAbsent(serviceEnum.name, key -> new Knife4jGatewayProperties.ServiceConfigInfo());
                if (serviceConfigInfo.getGroupName() == null) {
                    serviceConfigInfo.setGroupName(serviceEnum.desc);
                }
            }
        });
        return excludeService;
    }
}
