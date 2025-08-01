package org.github.bm.common.prop;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "bm.security")
public class SecurityProperties {


    /**
     * 忽略认证的url
     */
    private List<String> skipUrl = new ArrayList<>();

    /**
     * token配置
     */
    private JwtProperties token;

    /**
     * 内部调用验证配置
     */
    private InternalValidProperties internalValid;

    @Getter
    @Setter
    public static class JwtProperties {
        /**
         * token密钥
         */
        private String secret = "";
        /**
         * token前缀
         */
        private String prefix;

        /**
         * 获取签名
         */
        public String getSecret() {
            if (this.secret.length() < 32) {
                log.warn("Token已启用默认签名,请前往bm.security.token.secret设置32位的key");
                return "bm-importorg.github-zuuuYaoZ2l0aHViLXp1dXVZYW8=";
            }
            return this.secret;
        }

    }

    @Getter
    @Setter
    public static class InternalValidProperties {
        /**
         * 是否开启内部调用验证
         */
        private Boolean enable = false;

        /**
         * 内部调用的令牌
         */
        private String token;

        public String getToken() {
            if (StrUtil.isBlank(token)) {
                return "bm-internal-token-Z2l0aHViLXp1dXVZYW8=";
            }
            return token;
        }
    }
}
