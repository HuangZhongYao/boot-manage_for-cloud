package com.bstek.ureport.console;

import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ImportResource;

@Slf4j
@ImportResource("classpath:context.xml")
@BMCloudApplication
public class DataReportApplication implements ApplicationRunner {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_DATAREPORT.name, DataReportApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(
                """
                        \n
                        ----------------------------------------------------------
                            Application '{}' is running! Access URLs:
                            uReport designer: http://{}:port/{}/ureport/designer
                        ----------------------------------------------------------
                        """,
                ServiceEnum.APPLICATION_DATAREPORT.name,
                ServiceEnum.APPLICATION_GATEWAY.name,
                ServiceEnum.APPLICATION_DATAREPORT.name
        );
    }
}
