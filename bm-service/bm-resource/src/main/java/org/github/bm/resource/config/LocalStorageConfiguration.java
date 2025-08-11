package org.github.bm.resource.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.resource.rule.OssRule;
import org.github.bm.resource.service.impl.StorageServiceLocalImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 本地存储配置
 */
@Slf4j
@AllArgsConstructor
@AutoConfiguration(after = StorageConfiguration.class)
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(value = "storage.name", havingValue = "local")
public class LocalStorageConfiguration {

    private final StorageProperties storageProperties;
    private final OssRule ossRule;

    @Bean
    @ConditionalOnMissingBean(StorageServiceLocalImpl.class)
    public StorageServiceLocalImpl storageServiceLocal() {
        log.info("加载本地存储...");
        return new StorageServiceLocalImpl(storageProperties, ossRule);
    }

}
