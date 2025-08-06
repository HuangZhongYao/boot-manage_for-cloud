package com.bstek.ureport.console;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
@Slf4j
@ImportResource("classpath:context.xml")
@BMCloudApplication
public class DataReportApplication implements ApplicationRunner {
    @Resource
    Environment env;
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_DATAREPORT.name, DataReportApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String serverPort = env.getProperty("server.port");
        String appName = env.getProperty("spring.application.name");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        log.info(
                """
                        \n
                        ----------------------------------------------------------
                            Application '{}' is running! Access URLs:
                            Local: http://localhost:{}
                            External: http://{}:{}
                            uReport designer: http://{}:{}/ureport/designer
                        ----------------------------------------------------------
                        """,
                appName,
                serverPort,
                hostAddress,
                serverPort,
                hostAddress,
                serverPort
        );
    }
}
