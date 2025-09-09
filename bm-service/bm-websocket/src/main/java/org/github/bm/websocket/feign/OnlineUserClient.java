package org.github.bm.websocket.feign;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.websocket.service.IOnlineUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Time 2025-09-08 14:45
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Hidden
@RestController
public class OnlineUserClient implements IOnlineUserClient {

    @Resource
    private IOnlineUserService onlineUserService;

    @Override
    @PostMapping(ADD_ONLINE_USER)
    public Boolean addOnlineUser(@RequestParam("userId") Long userId) {
        return onlineUserService.addOnlineUser(userId);
    }

    @Override
    @DeleteMapping(REMOVE_ONLINE_USER)
    public Boolean removeOnlineUser(@RequestParam("userId") Long userId) {
        return onlineUserService.removeOnlineUser(userId);
    }

    @Override
    @GetMapping(IS_ONLINE)
    public Boolean isOnline(@RequestParam("userId") Long userId) {
        return onlineUserService.isOnline(userId);
    }

    @Override
    @GetMapping(GET_ONLINE_USER_LIST)
    public List<UserEntity> getOnlineUserList() {
        return onlineUserService.getOnlineUserList();
    }

    @Override
    @GetMapping(GET_ONLINE_USER_ID_LIST)
    public List<Long> getOnlineUserIdList() {
        return onlineUserService.getOnlineUserIdList();
    }
}
