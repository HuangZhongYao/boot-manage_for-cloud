package org.github.bm.resource.config;

import lombok.AllArgsConstructor;
import org.github.bm.resource.rule.BMOssRule;
import org.github.bm.resource.rule.OssRule;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 资源存储配置类
 *
 */
@AutoConfiguration
@AllArgsConstructor
@EnableConfigurationProperties(StorageProperties.class)
public class StorageConfiguration {

	@Bean
	@ConditionalOnMissingBean(OssRule.class)
	public OssRule ossRule() {
		return new BMOssRule();
	}

}
