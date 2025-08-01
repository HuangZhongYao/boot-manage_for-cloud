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
package org.github.bm.common.launch;

/**
 * Nacos配置常量
 */
public interface NacosConstant {
    /**
     * nacos 配置前缀
     */
    String NACOS_CONFIG_PREFIX = "bm";

    /**
     * nacos 组配置后缀
     */
    String NACOS_GROUP_SUFFIX = "-group";

    /**
     * nacos 配置文件类型
     */
    String NACOS_CONFIG_FORMAT = "yml";

    /**
     * nacos json配置文件类型
     */
    String NACOS_CONFIG_JSON_FORMAT = "json";

    /**
     * nacos 是否刷新
     */
    String NACOS_CONFIG_REFRESH = "true";

    /**
     * nacos 分组
     */
    String NACOS_CONFIG_GROUP = "DEFAULT_GROUP";

    /**
     * 构建服务对应的 dataId
     *
     * @param appName 服务名
     * @return dataId
     */
    static String dataId(String appName) {
        return dataId(appName, NACOS_CONFIG_FORMAT);
    }

    /**
     * 构建服务对应的 dataId
     *
     * @param appName 服务名
     * @param format  文件类型
     * @return dataId
     */
    static String dataId(String appName, String format) {
        return appName + "." + format;
    }

}
