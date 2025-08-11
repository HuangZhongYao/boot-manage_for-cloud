package org.github.bm.resource.config;

import io.minio.MinioClient;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import lombok.extern.slf4j.Slf4j;
import org.github.bm.resource.rule.OssRule;
import org.github.bm.resource.service.impl.StorageServiceMinioOssImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Minio配置类
 *
 */
@Slf4j
@AllArgsConstructor
@AutoConfiguration(after = StorageConfiguration.class)
@ConditionalOnClass({MinioClient.class})
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(value = "storage.name", havingValue = "minio")
public class MinioConfiguration {

	private final StorageProperties storageProperties;
	private final OssRule ossRule;


	@Bean
	@SneakyThrows
	@ConditionalOnMissingBean(MinioClient.class)
	public MinioClient minioClient() {
		return MinioClient.builder()
			.endpoint(storageProperties.getEndpoint())
			.credentials(storageProperties.getAccessKey(), storageProperties.getSecretKey())
			.build();
	}

	@Bean
	@ConditionalOnBean({MinioClient.class})
	@ConditionalOnMissingBean(StorageServiceMinioOssImpl.class)
	public StorageServiceMinioOssImpl storageServiceMinioOss(MinioClient minioClient) {
		log.info("加载MinIO对象存储...");
		return new StorageServiceMinioOssImpl(minioClient, ossRule, storageProperties);
	}

}
