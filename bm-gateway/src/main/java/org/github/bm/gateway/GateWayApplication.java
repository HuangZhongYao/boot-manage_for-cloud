package org.github.bm.gateway;

import org.github.bm.common.constant.AppConstant;
import org.github.bm.common.launch.BMApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Time 2025-07-28 11:19
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {
        BMApplication.run(AppConstant.APPLICATION_GATEWAY_NAME, GateWayApplication.class, args);
    }


}
