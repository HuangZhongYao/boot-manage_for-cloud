package org.github.bm.core.generation;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 雪花id配置
 */
@Slf4j
@Configuration
public class SnowflakeConfig {

    @Bean
    public SnowflakeGenerator snowflakeGenerator() {
        log.info("SnowflakeGenerator 初始化中...");
        return new SnowflakeGenerator();
    }
}
