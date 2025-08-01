package org.github.bm.core.web;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * WebMvc配置类
 *
 * @Desc WebMvc配置类
 * @Time 2024-07-11 16:23
 * @Author HuangZhongYao
 */
@Slf4j
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 消息转化器日期类型处理
     */
    @Value("${spring.jackson.date-format}")
    String dateFormat;

    /**
     * 消息转换器日期时间类型处理
     */
    @Value("${spring.jackson.local-date-format}")
    String localDateFormat;

    /**
     * 时区
     */
    @Value("${spring.jackson.time-zone}")
    String timeZone;

    /**
     * 配置jackson消息转换器。处理LocalDateTime类型序列化和反序列化
     */
    @Bean
    public MappingJackson2HttpMessageConverter configureMessageConverters() {
        log.info("加载 jackson JavaTimeModule 序列化与反序列化.........");
        // 创建Jackson2ObjectMapperBuilder以自定义ObjectMapper
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.modules(new JavaTimeModule());
        builder.timeZone(TimeZone.getTimeZone(timeZone));
        // 自定义Date序列化、反序列化
        builder.dateFormat(new SimpleDateFormat(dateFormat));
        // 自定义LocalDateTime序列化、反序列化
        builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateFormat)));
        builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateFormat)));
        // 自定义LocalDate序列化、反序列化
        builder.serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(localDateFormat)));
        builder.deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(localDateFormat)));
        return new MappingJackson2HttpMessageConverter(builder.build());
    }

    /**
     * 配置静态资源的处理规则
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("配置静态资源目录.........");
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 静态资源目录
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        // webjars
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        // swagger-resources
        registry.addResourceHandler("/swagger-resources/**")
                .addResourceLocations("classpath:/META-INF/resources/");
        // swagger-ui
        registry.addResourceHandler("/swagger-ui*/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/5.10.3/");
        // knife4j-ui
        registry.addResourceHandler("/doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }



}
