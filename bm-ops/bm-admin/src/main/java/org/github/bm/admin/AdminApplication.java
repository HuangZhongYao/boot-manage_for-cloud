package org.github.bm.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@Slf4j
@EnableAdminServer
@SpringBootApplication
public class AdminApplication implements ApplicationRunner {
    @Resource
    Environment env;

    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_ADMIN.name, AdminApplication.class, args);
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
                            SpringBoot-Admin WebUrl: http://{}:{}/doc.html
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
