package org.github.bm.websocket.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.websocket.feign.fallback.OnlineUserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Time 2025-09-08 14:43
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@FeignClient(value = AppConstant.APPLICATION_WEBSOCKET_NAME, contextId = "onlineUserClient",fallback = OnlineUserClientFallback.class)
public interface IOnlineUserClient extends BaseFeign {
    /**
     * 在线用户Feign API路径前缀
     */
    String API_PREFIX = BASE_API_PREFIX + "/onlineUser";
}
