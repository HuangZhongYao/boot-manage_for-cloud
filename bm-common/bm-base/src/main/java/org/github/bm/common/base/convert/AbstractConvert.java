package org.github.bm.common.base.convert;

import java.util.List;

/**
 * 抽象转换器
 * 注意实体和VO的属性名类型称要一致。都要有无参构造函数和全参构造函数
 *
 * @param <Entity> 实体
 * @param <VO>     vo
 */
public interface AbstractConvert<Entity, VO> {
    /**
     * entity转VO
     *
     * @param entity 实体
     * @return vo
     */
    VO toVO(Entity entity);

    /**
     * entityList转VOList
     *
     * @param entityList 实体列表
     * @return vo列表
     */
    List<VO> toVOList(List<Entity> entityList);

    /**
     * VO转entity
     *
     * @param vo vo
     * @return VO转entity
     */
    Entity toEntity(VO vo);

    /**
     * VOList转entityList
     *
     * @param voList vo列表
     * @return entityList
     */
    List<Entity> toEntityList(List<VO> voList);
}
