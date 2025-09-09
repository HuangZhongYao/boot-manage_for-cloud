package org.github.bm.websocket.feign.fallback;

import org.github.bm.user.entity.UserEntity;
import org.github.bm.websocket.feign.IOnlineUserClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Time 2025-09-08 14:43
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class OnlineUserClientFallback implements IOnlineUserClient {
    @Override
    public Boolean addOnlineUser(Long userId) {
        return null;
    }

    @Override
    public Boolean removeOnlineUser(Long userId) {
        return null;
    }

    @Override
    public Boolean isOnline(Long userId) {
        return null;
    }

    @Override
    public List<UserEntity> getOnlineUserList() {
        return List.of();
    }

    @Override
    public List<Long> getOnlineUserIdList() {
        return List.of();
    }
}
