package org.github.bm.websocket;

import org.github.bm.base.constant.ServiceEnum;
import org.github.bm.base.launch.BMApplication;
import org.github.bm.core.annotations.BMCloudApplication;

@BMCloudApplication
public class WebSocketApplication {
    public static void main(String[] args) {
        BMApplication.run(ServiceEnum.APPLICATION_WEBSOCKET, WebSocketApplication.class, args);
    }
}
