package org.github.bm.auth.converter;

import org.github.bm.base.security.AuthInfo;
import org.github.bm.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Time 2025-08-14 15:53
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring")
public interface IAuthInfoConverter {

    @Mapping(source = "id", target = "userId") // 属性名不一致，手动指定映射
    AuthInfo toAuthInfo(UserEntity userEntity);
}
