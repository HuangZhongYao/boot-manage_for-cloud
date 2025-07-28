package org.github.bm.gateway;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Time 2025-07-28 11:19
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@SpringBootApplication
@RestController
public class GateWayApplication implements ApplicationRunner {

    @Value(value = "${yy.hello}")
    private String message;

    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_GATEWAY_NAME, GateWayApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

    @GetMapping("/message")
    public String message() {
        return message;
    }
}
