package org.github.bm.system.service;



import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.dto.AddResourcesInputDTO;
import org.github.bm.system.dto.EditResourcesInputDTO;
import org.github.bm.system.dto.SetResourcesStateInputDTO;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVO;

import java.util.List;

/**
 * @Desc 资源管理Service
 * @Time 2024-07-11 16:32
 * @Author HuangZhongYao
 */
public interface IResourcesService {

    /**
     * 删除资源
     * @param inputDTO 包含多个资源ID的输入参数
     * @return 删除结果，true表示删除成功，false表示删除失败
     */
    Boolean delResources(BaseManyLongIdInputDTO inputDTO);

    /**
     * 添加资源
     * @param inputDTO 添加资源的输入参数
     * @return 添加结果，true表示添加成功，false表示添加失败
     */
    Boolean addResources(AddResourcesInputDTO inputDTO);

    /**
     * 获取资源树结构
     * @return 资源树结构列表
     */
    List<ResourcesTreeVO> resourcesTree();

    /**
     * 查询资源下的按钮
     * @param parentId 资源id
     * @return 下级按钮集合
     */
    List<ResourcesVO> button(Long parentId);

    /**
     * 编辑资源
     * @param inputDTO 编辑资源的输入参数
     * @return 编辑结果，true表示编辑成功，false表示编辑失败
     */
    Boolean editResources(EditResourcesInputDTO inputDTO);

    /**
     * 设置资源状态
     * @param inputDTO 设置资源状态的输入参数
     * @return 设置结果，true表示设置成功，false表示设置失败
     */
    Boolean setState(SetResourcesStateInputDTO inputDTO);
}

