package org.github.bm.websocket.service;

import org.github.bm.user.entity.UserEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Time 2025-09-08 14:42
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public interface IOnlineUserService {

    /**
     * 添加在线用户
     *
     * @param userId 用户ID
     * @return 添加成功返回true，否则返回false
     */
    boolean addOnlineUser(Serializable userId);

    /**
     * 移出在线用户
     *
     * @param userId 用户ID
     * @return 移出成功返回true，否则返回false
     */
    boolean removeOnlineUser(Serializable userId);

    /**
     * 判断用户是否在线
     *
     * @param userId 用户ID
     * @return 在线返回true，否则返回false
     */
    boolean isOnline(Serializable userId);

    /**
     * 获取所有在线用户列表
     *
     * @return 在线用户信息列表
     */
    List<UserEntity> getOnlineUserList();

    /**
     * 获取所有在线用户Id列表
     *
     * @return 在线用户Id列表
     */
    List<Long> getOnlineUserIdList();
}

