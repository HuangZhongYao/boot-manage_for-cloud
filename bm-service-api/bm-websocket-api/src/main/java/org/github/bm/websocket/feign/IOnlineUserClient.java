package org.github.bm.websocket.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.websocket.feign.fallback.OnlineUserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Time 2025-09-08 14:43
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@FeignClient(value = AppConstant.APPLICATION_WEBSOCKET_NAME, contextId = "onlineUserClient", fallback = OnlineUserClientFallback.class)
public interface IOnlineUserClient extends BaseFeign {
    /**
     * 在线用户Feign API路径前缀
     */
    String API_PREFIX = BASE_API_PREFIX + "/onlineUser";
    String ADD_ONLINE_USER = API_PREFIX + "/addOnlineUser";
    String REMOVE_ONLINE_USER = API_PREFIX + "/removeOnlineUser";
    String IS_ONLINE = API_PREFIX + "/isOnline";
    String GET_ONLINE_USER_LIST = API_PREFIX + "/getOnlineUserList";
    String GET_ONLINE_USER_ID_LIST = API_PREFIX + "/getOnlineUserIdList";

    /**
     * 添加在线用户
     *
     * @param userId 用户ID
     * @return 添加成功返回true，否则返回false
     */
    @PostMapping(ADD_ONLINE_USER)
    Boolean addOnlineUser(@RequestParam("userId") Long userId);

    /**
     * 移出在线用户
     *
     * @param userId 用户ID
     * @return 移出成功返回true，否则返回false
     */
    @DeleteMapping(REMOVE_ONLINE_USER)
    Boolean removeOnlineUser(@RequestParam("userId") Long userId);

    /**
     * 判断用户是否在线
     *
     * @param userId 用户ID
     * @return 在线返回true，否则返回false
     */
    @GetMapping(IS_ONLINE)
    Boolean isOnline(@RequestParam("userId") Long userId);

    /**
     * 获取所有在线用户列表
     *
     * @return 在线用户信息列表
     */
    @GetMapping(GET_ONLINE_USER_LIST)
    List<UserEntity> getOnlineUserList();

    /**
     * 获取所有在线用户ID列表
     *
     * @return 在线用户ID列表
     */
    @GetMapping(GET_ONLINE_USER_ID_LIST)
    List<Long> getOnlineUserIdList();
}
