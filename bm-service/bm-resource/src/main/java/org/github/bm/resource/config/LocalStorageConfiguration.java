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

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.resource.rule.OssRule;
import org.github.bm.resource.service.impl.StorageServiceAliOssImpl;
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
    @ConditionalOnMissingBean(StorageServiceAliOssImpl.class)
    public StorageServiceLocalImpl storageServiceLocal() {
        log.info("加载本地存储...");
        return new StorageServiceLocalImpl(storageProperties, ossRule);
    }

}
