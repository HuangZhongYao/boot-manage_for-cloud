package org.github.bm.websocket;

import org.github.bm.common.constant.ServiceEnum;
import org.github.bm.common.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

@BMCloudApplication
public class WebSocketApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_WEBSOCKET, WebSocketApplication.class, args);
    }
}
