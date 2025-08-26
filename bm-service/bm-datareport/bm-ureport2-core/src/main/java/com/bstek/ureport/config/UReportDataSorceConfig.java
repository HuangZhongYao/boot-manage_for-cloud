package com.bstek.ureport.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.feign.IDataSourceFeignClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UReportDataSorceConfig implements ApplicationRunner {
    @Resource
    BuildinDataSourceRegistrar buildinDataSourceRegistrar;
    @Resource
    IDataSourceFeignClient dataSourceFeignClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            List<DataSourceEntity> dataSourceEntityList = dataSourceFeignClient.getDataSourceAll();
            buildinDataSourceRegistrar.registerMultipleDataSources(dataSourceEntityList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请先启动 bm-resource服务完成后再启动");
        }
    }
}
