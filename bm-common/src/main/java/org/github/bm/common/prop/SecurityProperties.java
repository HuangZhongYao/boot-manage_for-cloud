package org.github.bm.common.prop;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "bm.security")
public class SecurityProperties {


    private List<String> skipUrl = new ArrayList<>();

    private JwtProperties token;

    @Getter
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
                return "bm-importorg.springframework.boot.context.proper";
            }
            return this.secret;
        }

    }
}
