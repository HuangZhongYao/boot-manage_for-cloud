package org.github.bm.system.converter;

import org.github.bm.system.entity.RoleEntity;
import org.github.bm.system.vo.RoleVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Time 2025-08-15 16:51
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring",builder = @org.mapstruct.Builder(disableBuilder = true)) // disableBuilder禁用Builder构建器否则父类属性无法赋值
public interface RoleConverter {

    RoleVO toRoleVo(RoleEntity roleEntity);

    List<RoleVO> toRoleVo(List<RoleEntity> roleEntityList);
}
