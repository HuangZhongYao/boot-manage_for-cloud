package org.github.bm.websocket.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.base.constant.RedisConstant;
import org.github.bm.core.service.IRedisService;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.IUserClient;
import org.github.bm.websocket.service.IOnlineUserService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class OnlineUserServiceImpl implements IOnlineUserService {
    @Resource
    private IUserClient userClient;
    @Resource
    private IRedisService redisService;

    @Override
    public boolean addOnlineUser(Serializable userId) {
        try {
            if (userId == null) {
                return false;
            }

            // 添加到在线用户集合
            String onlineUserSetKey = RedisConstant.OnlineUser.ONLINE_USER_ID_SET_KEY;
            redisService.sSet(onlineUserSetKey, userId.toString());

            return true;
        } catch (Exception e) {
            log.error("添加在线用户时发生异常,userId: {}", userId, e);
            return false;
        }
    }

    @Override
    public boolean removeOnlineUser(Serializable userId) {
        try {
            if (userId == null) {
                return false;
            }
            String onlineUserSetKey = RedisConstant.OnlineUser.ONLINE_USER_ID_SET_KEY;
            redisService.setRemove(onlineUserSetKey, userId.toString());
            return true;
        } catch (Exception e) {
            log.error("移除在线用户时发生异常,userId: {}", userId, e);
            return false;
        }
    }

    @Override
    public boolean isOnline(Serializable userId) {
        try {
            if (userId == null) {
                return false;
            }

            String onlineUserSetKey = RedisConstant.OnlineUser.ONLINE_USER_ID_SET_KEY;
            return redisService.sHasKey(onlineUserSetKey, userId.toString());
        } catch (Exception e) {
            log.error("isOnline线用户时发生异常,userId: {}", userId, e);
            return false;
        }
    }

    @Override
    public List<UserEntity> getOnlineUserList() {
        try {
            // 获取所有在线用户ID
            String onlineUserSetKey = RedisConstant.OnlineUser.ONLINE_USER_ID_SET_KEY;
            Set<Object> onlineUserIds = redisService.sGet(onlineUserSetKey);
            // 批量获取用户详细信息
            List<UserEntity> onlineUserList = userClient.getUserByIDList(onlineUserIds.stream().map(id -> Long.valueOf(id.toString())).toList());
            return onlineUserList;
        } catch (Exception e) {
            log.error("获取在线线用户时发生异常", e);
            return List.of();
        }
    }

    @Override
    public List<Long> getOnlineUserIdList() {
        try {
            // 获取所有在线用户ID
            String onlineUserSetKey = RedisConstant.OnlineUser.ONLINE_USER_ID_SET_KEY;
            Set<Object> onlineUserIds = redisService.sGet(onlineUserSetKey);

            if (onlineUserIds == null || onlineUserIds.isEmpty()) {
                return List.of();
            }
            return onlineUserIds.stream().map(id -> Long.valueOf(id.toString())).toList();
        } catch (Exception e) {
            log.error("获取在线用户Id列表时发生异常", e);
            return List.of();
        }
    }
}
