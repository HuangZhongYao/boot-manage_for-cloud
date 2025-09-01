package org.github.bm.user.feign.fallback;

import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.IUserClient;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Time 2025-09-01 16:56
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class UserClientFallback implements IUserClient {
    /**
     * 根据ID查询用户
     *
     * @param id 用户 ID
     * @return 用户实体
     */
    @Override
    public UserEntity getUserByID(Serializable id) {
        return null;
    }

    /**
     * 根据ID列表查询用户
     *
     * @param ids ID列表
     * @return 用户实体列表
     */
    @Override
    public List<UserEntity> getUserByIDList(List<Long> ids) {
        return List.of();
    }

    /**
     * 根据账号查询用户
     *
     * @param account 账号
     * @return 用户实体
     */
    @Override
    public UserEntity getUserByAccount(String account) {
        return null;
    }
}
