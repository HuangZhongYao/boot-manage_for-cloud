package org.github.bm.system.repository;

import org.github.bm.common.mybatis.BaseMapperExtension;
import org.github.bm.system.entity.RoleResourcesEntity;
import org.springframework.stereotype.Repository;

/**
 * 角色权限表数据库访问对象
 *
 * @Desc 用户角色表仓储层
 * @Time 2024-07-17 09:32
 * @Author HuangZhongYao
 */
@Repository
public interface RoleResourcesRepository extends BaseMapperExtension<RoleResourcesEntity> {
}
