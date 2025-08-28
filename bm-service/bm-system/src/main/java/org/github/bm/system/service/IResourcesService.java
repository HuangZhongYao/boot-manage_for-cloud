package org.github.bm.system.service;



import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.dto.AddResourcesInputDTO;
import org.github.bm.system.dto.EditResourcesInputDTO;
import org.github.bm.system.dto.SetResourcesStateInputDTO;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVO;

import java.util.List;

/**
 * @Desc 用户管理Service
 * @Time 2024-07-11 16:32
 * @Author HuangZhongYao
 */
public interface IResourcesService {


    Boolean delResources(BaseManyLongIdInputDTO inputDTO);

    Boolean addResources(AddResourcesInputDTO inputDTO);

    List<ResourcesTreeVO> resourcesTree();

    /**
     * 查询资源下的按钮
     * @param parentId 资源id
     * @return 下级按钮集合
     */
    List<ResourcesVO> button(Long parentId);

    Boolean editResources(EditResourcesInputDTO inputDTO);

    Boolean setState(SetResourcesStateInputDTO inputDTO);
}
