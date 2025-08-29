package org.github.bm.system.converter;

import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Time 2025-08-15 16:39
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring",builder = @org.mapstruct.Builder(disableBuilder = true)) // disableBuilder禁用Builder构建器否则父类属性无法赋值
public interface ResourcesConverter {
    List<ResourcesTreeVO> toResourcesTreeVoList(List<ResourcesEntity> resourcesEntityList);

    List<ResourcesVO> toResourcesVOList(List<ResourcesEntity> resourcesEntityList);
}
