package org.github.bm.system.converter;

import org.github.bm.system.entity.RoleEntity;
import org.github.bm.system.vo.RoleVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Time 2025-08-15 16:51
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    RoleVo toRoleVo(RoleEntity roleEntity);

    List<RoleVo> toRoleVo(List<RoleEntity> roleEntityList);
}
