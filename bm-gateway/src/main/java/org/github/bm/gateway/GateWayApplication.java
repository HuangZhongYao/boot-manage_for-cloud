package org.github.bm.gateway;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * Time 2025-07-28 11:19
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {AppConstant.BASE_PACKAGES})
public class GateWayApplication implements ApplicationRunner {
    @Resource
    Environment env;
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_GATEWAY.name, GateWayApplication.class, args);
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
                            Doc Knife4j-ui: http://{}:{}/doc.html
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
