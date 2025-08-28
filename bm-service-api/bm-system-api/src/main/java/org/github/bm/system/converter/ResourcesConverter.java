package org.github.bm.system.converter;

import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Time 2025-08-15 16:39
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring")
public interface ResourcesConverter {
    List<ResourcesTreeVO> toResourcesTreeVoList(List<ResourcesEntity> resourcesEntityList);

    List<ResourcesVo> toResourcesVOList(List<ResourcesEntity> resourcesEntityList);
}
