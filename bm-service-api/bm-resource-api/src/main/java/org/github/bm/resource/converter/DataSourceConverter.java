package org.github.bm.resource.converter;

import org.github.bm.resource.dto.DataSourceAddInputDTO;
import org.github.bm.resource.dto.DataSourceEditInputDTO;
import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.vo.DataSourceVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 数据源转换器接口
 * 用于在数据源相关的DTO、Entity和VO对象之间进行转换
 */
@Mapper(componentModel = "spring",builder = @org.mapstruct.Builder(disableBuilder = true)) // disableBuilder禁用Builder构建器否则父类属性无法赋值
public interface DataSourceConverter {
    /**
     * 将dataSourceAddInputDTO转换为DataSourceEntity
     * @param dataSourceAddInputDTO 数据源DTO对象
     * @return 转换后的数据源实体对象
     */
    DataSourceEntity toEntity(DataSourceAddInputDTO dataSourceAddInputDTO);

    /**
     * 将dataSourceEditInputDTO转换为DataSourceEntity
     * @param dataSourceEditInputDTO 数据源DTO对象
     * @return 转换后的数据源实体对象
     */
    DataSourceEntity toEntity(DataSourceEditInputDTO dataSourceEditInputDTO);

    /**
     * 将DataSourceEntity转换为DataSourceDTO
     * @param dataSourceEntity 数据源实体对象
     * @return 转换后的数据源DTO对象
     */
    DataSourceAddInputDTO toDTO(DataSourceEntity dataSourceEntity);

    /**
     * 将DataSourceEntity转换为DataSourceVO
     * @param dataSourceEntity 数据源实体对象
     * @return 转换后的数据源VO对象
     */
    DataSourceVO toVO(DataSourceEntity dataSourceEntity);

    /**
     * 将DataSourceEntity列表转换为DataSourceVO列表
     * @param dataSourceEntityList 数据源实体列表
     * @return 转换后的数据源VO列表
     */
    List<DataSourceVO> toVOList(List<DataSourceEntity> dataSourceEntityList);
}

