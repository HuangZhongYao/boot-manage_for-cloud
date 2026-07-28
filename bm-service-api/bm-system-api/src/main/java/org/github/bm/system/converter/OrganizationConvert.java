package org.github.bm.system.converter;

import org.github.bm.base.base.convert.AbstractConvert;
import org.github.bm.system.dto.AddOrganizationInputDTO;
import org.github.bm.system.dto.EditOrganizationInputDTO;
import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.vo.OrganizationVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @org.mapstruct.Builder(disableBuilder = true))
// disableBuilder禁用Builder构建器否则父类属性无法赋值
public interface OrganizationConvert extends AbstractConvert<OrganizationEntity, OrganizationVO> {

    OrganizationEntity toEntity(AddOrganizationInputDTO inputDTO);

    OrganizationEntity toEntity(EditOrganizationInputDTO inputDTO);
}
