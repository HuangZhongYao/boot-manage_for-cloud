package com.bstek.ureport.config;

import com.bstek.ureport.definition.datasource.BuildinDatasource;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.resource.entity.DataSourceEntity;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Component
@Slf4j
public class BuildinDataSourceRegistrar {

    private final ApplicationContext applicationContext;

    public BuildinDataSourceRegistrar(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 动态创建多个 BuildinDatasource 并注册为 Spring Bean
     *
     * @param dataSourceProps 数据源配置列表
     */
    public void registerMultipleDataSources(List<DataSourceEntity> dataSourceProps) {
        // 确保是可配置的上下文
        ConfigurableApplicationContext configurableContext = (ConfigurableApplicationContext) applicationContext;
        ConfigurableListableBeanFactory beanFactory = configurableContext.getBeanFactory();
        int index = 1;
        for (DataSourceEntity prop : dataSourceProps) {
            String beanName = prop.getType().desc + "UreportDatasource" + index;
            // 避免重复注册
            if (beanFactory.containsBean(beanName)) {
                continue;
            }
            // 动态创建一个 BuildinDatasource
            BuildinDatasource dataSource = buildHikariDataSource(prop);
            // 将该 BuildinDatasource 注册为 Spring
            beanFactory.registerSingleton(beanName, dataSource);
            index++;
        }
    }

    private BuildinDatasource buildHikariDataSource(DataSourceEntity dataSourceEntity) {

        return new BuildinDatasource() {
            @Override
            public String name() {
                return dataSourceEntity.getName();
            }

            @Override
            public Connection getConnection() {
                HikariDataSource ds = new HikariDataSource();
                ds.setJdbcUrl(dataSourceEntity.getUrl());
                ds.setUsername(dataSourceEntity.getUsername());
                ds.setPassword(dataSourceEntity.getPassword());
                ds.setDriverClassName(dataSourceEntity.getDriverClassName());
                ds.setMaximumPoolSize(10);
                ds.setMinimumIdle(2);
                try {
                    return ds.getConnection();
                } catch (SQLException e) {
                    log.error("创建Ureport数据源失败");
                    throw new RuntimeException(e);
                }
            }
        };
    }
}