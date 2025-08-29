package org.github.bm.user.converter;

import org.github.bm.system.vo.RoleUserModel;
import org.github.bm.user.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Time 2025-08-14 21:58
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring",builder = @org.mapstruct.Builder(disableBuilder = true)) // disableBuilder禁用Builder构建器否则父类属性无法赋值
public interface UserConverter {

    List<RoleUserModel> toRoleUserModels(List<UserEntity> userEntityList);
}
