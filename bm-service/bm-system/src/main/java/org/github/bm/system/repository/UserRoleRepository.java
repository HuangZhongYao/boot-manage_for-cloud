package org.github.bm.system.repository;

import org.github.bm.common.mybatis.BaseMapperExtension;
import org.github.bm.system.entity.UserRoleEntity;
import org.springframework.stereotype.Repository;

/**
 * 用户角色表数据库访问对象
 * @Desc 用户角色表仓储层
 * @Time 2024-07-11 16:32
 * @Author HuangZhongYao
 */
@Repository
public interface UserRoleRepository extends BaseMapperExtension<UserRoleEntity> {
}
