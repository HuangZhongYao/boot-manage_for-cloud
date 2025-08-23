package org.github.bm.system.service;



import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.dto.*;
import org.github.bm.system.vo.DictDataVO;
import org.github.bm.system.vo.DictTypeTreeVO;

import java.util.List;

/**
 * @Desc Created by IntelliJ IDEA.
 * @Author ZhongYao.Huang (https://github.com/HuangZhongYao)
 * @Copyright ZuuuuYao By Github
 * @Time 2024-08-18 4:07
 */
public interface IDictService {
    Boolean addDictData(AddDictInputDTO inputDTO);

    Boolean delDictData(BaseManyLongIdInputDTO inputDTO);

    Boolean setStateDictData(SetStateDictInputDTO inputDTO);

    Boolean editDictData(EditDictInputDTO inputDTO);

    List<DictDataVO> dictDataQueryListByDictTypeCode(String dictTypeCode);

    List<DictDataVO> dictDataQueryList(Long dictTypeId);

    Boolean addDictType(AddDictTypeInputDTO inputDTO);

    Boolean delDictType(BaseManyLongIdInputDTO inputDTO);

    Boolean editDictType(EditDictTypeInputDTO inputDTO);

    List<DictTypeTreeVO> dictTypeTree();

    Boolean setStateDictType(SetStateDictInputDTO inputDTO);

}
