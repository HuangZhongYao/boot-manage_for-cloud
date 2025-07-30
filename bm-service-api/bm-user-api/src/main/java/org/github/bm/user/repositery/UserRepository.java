package org.github.bm.user.repositery;

import org.github.bm.common.mybatis.BaseMapperExtension;
import org.github.bm.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * 用户表数据库访问对象
 * @Desc 用户仓储层
 * @Time 2024-07-11 16:32
 * @Author HuangZhongYao
 */
@Repository
public interface UserRepository extends BaseMapperExtension<UserEntity> {
}
