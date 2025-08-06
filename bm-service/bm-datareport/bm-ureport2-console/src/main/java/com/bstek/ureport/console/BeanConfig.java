package com.bstek.ureport.console;
 
import com.bstek.ureport.definition.datasource.BuildinDatasource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: jack
 * @Description: springboot实体类配置
 * @Date Create in 10:25 2020-03-21
 **/
@Configuration
public class BeanConfig {
 
    @Bean
    public ServletRegistrationBean ureport2Servlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
        return registrationBean;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        System.out.println("------------------dataSource------------------");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bm?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&tinyInt1isBit=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&useSSL=false");
        config.setUsername("root");
        config.setPassword("root");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        HikariDataSource hikariDataSource = new HikariDataSource(config);
        return hikariDataSource;
    }


    @Bean
    public  BuildinDatasource buildinDatasource(final DataSource dateSource) {
        System.out.println("------------------buildinDatasource------------------");
        return new BuildinDatasource() {
            @Override
            public String name() {
                return "default";
            }
            @Override
            public Connection getConnection() {
                try {
                    return dateSource.getConnection();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Bean
    public  BuildinDatasource buildinDatasource2(final DataSource dateSource) {
        System.out.println("------------------buildinDatasource------------------");
        return new BuildinDatasource() {
            @Override
            public String name() {
                return "local";
            }
            @Override
            public Connection getConnection() {
                try {
                    return dateSource.getConnection();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

}