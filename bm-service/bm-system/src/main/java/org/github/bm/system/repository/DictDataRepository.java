package org.github.bm.system.repository;

import org.github.bm.base.mybatis.BaseMapperExtension;
import org.github.bm.system.entity.DictDataEntity;
import org.github.bm.system.vo.DictDataVO;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Desc Created by IntelliJ IDEA.
 * @Author ZhongYao.Huang (https://github.com/HuangZhongYao)
 * @Copyright ZuuuuYao By Github
 * @Time 2024-08-18 3:59
 */
@Repository
public interface DictDataRepository extends BaseMapperExtension<DictDataEntity> {
    /**
     * 查询所有字典数据列表
     *
     * @return 字典数据视图对象列表
     */
    List<DictDataVO>  allDictDataQueryList();

    /**
     * 根据字典类型ID查询字典数据列表
     *
     * @param dictTypeId 字典类型ID
     * @return 字典数据视图对象列表
     */
    List<DictDataVO>  dictDataQueryListByDictTypeId(@Param("dictTypeId") Long dictTypeId);
}
