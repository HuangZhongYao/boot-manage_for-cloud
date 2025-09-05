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
    /**
     * 添加字典数据
     * @param inputDTO 添加字典数据输入参数
     * @return 添加结果，true表示成功，false表示失败
     */
    Boolean addDictData(AddDictInputDTO inputDTO);

    /**
     * 删除字典数据
     * @param inputDTO 删除字典数据输入参数，包含要删除的字典数据ID列表
     * @return 删除结果，true表示成功，false表示失败
     */
    Boolean delDictData(BaseManyLongIdInputDTO inputDTO);

    /**
     * 设置字典数据状态
     * @param inputDTO 设置字典数据状态输入参数
     * @return 设置结果，true表示成功，false表示失败
     */
    Boolean setStateDictData(SetStateDictInputDTO inputDTO);

    /**
     * 编辑字典数据
     * @param inputDTO 编辑字典数据输入参数
     * @return 编辑结果，true表示成功，false表示失败
     */
    Boolean editDictData(EditDictInputDTO inputDTO);

    /**
     * 根据字典类型编码查询字典数据列表
     * @param dictTypeCode 字典类型编码
     * @return 字典数据列表
     */
    List<DictDataVO> dictDataQueryListByDictTypeCode(String dictTypeCode);

    /**
     * 根据字典类型ID查询字典数据列表
     * @param dictTypeId 字典类型ID
     * @return 字典数据列表
     */
    List<DictDataVO> dictDataQueryList(Long dictTypeId);

    /**
     * 添加字典类型
     * @param inputDTO 添加字典类型输入参数
     * @return 添加结果，true表示成功，false表示失败
     */
    Boolean addDictType(AddDictTypeInputDTO inputDTO);

    /**
     * 删除字典类型
     * @param inputDTO 删除字典类型输入参数，包含要删除的字典类型ID列表
     * @return 删除结果，true表示成功，false表示失败
     */
    Boolean delDictType(BaseManyLongIdInputDTO inputDTO);

    /**
     * 编辑字典类型
     * @param inputDTO 编辑字典类型输入参数
     * @return 编辑结果，true表示成功，false表示失败
     */
    Boolean editDictType(EditDictTypeInputDTO inputDTO);

    /**
     * 获取字典类型树结构
     * @return 字典类型树结构列表
     */
    List<DictTypeTreeVO> dictTypeTree();

    /**
     * 设置字典类型状态
     * @param inputDTO 设置字典类型状态输入参数
     * @return 设置结果，true表示成功，false表示失败
     */
    Boolean setStateDictType(SetStateDictInputDTO inputDTO);

    /**
     * 获取所有字典数据列表
     * @return 所有字典数据列表
     */
    List<DictDataVO> allDictDataQueryList();
}

