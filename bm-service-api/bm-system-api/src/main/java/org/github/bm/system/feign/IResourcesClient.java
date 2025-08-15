package org.github.bm.system.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.vo.ResourcesTreeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Time 2025-08-15 15:44
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@FeignClient(value = AppConstant.APPLICATION_SYSTEM_NAME, contextId = "resourcesClient")
public interface IResourcesClient extends BaseFeign {
    String QUERY_PERMISSIONS_TREE_BY_USER_ID = "/resources/queryPermissionsTree";
    String QUERY_PERMISSIONS_LIST_BY_USER_ID = "/resources/queryPermissionsList";


    /**
     * 获取用户权限列表
     *
     * @param userId 用户id
     * @return 权限列表
     */
    @GetMapping(value = QUERY_PERMISSIONS_LIST_BY_USER_ID)
    List<ResourcesEntity> queryPermissionsListByUserId(@RequestParam("userId") Long userId);

    /**
     * 获取用户权限树
     *
     * @param userId 用户id
     * @return 权限树
     */
    @GetMapping(value = QUERY_PERMISSIONS_TREE_BY_USER_ID)
    List<ResourcesTreeVo> queryPermissionsTreeByUserId(@RequestParam("userId") Long userId);
}
