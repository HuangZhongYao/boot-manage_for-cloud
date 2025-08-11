/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
@AutoConfiguration(after = OssConfiguration.class)
@ConditionalOnClass({MinioClient.class})
@EnableConfigurationProperties(OssProperties.class)
@ConditionalOnProperty(value = "storage.name", havingValue = "minio")
public class MinioConfiguration {

	private final OssProperties ossProperties;
	private final OssRule ossRule;


	@Bean
	@SneakyThrows
	@ConditionalOnMissingBean(MinioClient.class)
	public MinioClient minioClient() {
		return MinioClient.builder()
			.endpoint(ossProperties.getEndpoint())
			.credentials(ossProperties.getAccessKey(), ossProperties.getSecretKey())
			.build();
	}

	@Bean
	@ConditionalOnBean({MinioClient.class})
	@ConditionalOnMissingBean(StorageServiceMinioOssImpl.class)
	public StorageServiceMinioOssImpl storageServiceMinioOss(MinioClient minioClient) {
		log.info("加载MinIO对象存储...");
		return new StorageServiceMinioOssImpl(minioClient, ossRule, ossProperties);
	}

}
