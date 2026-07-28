package org.github.bm.system.feign;

import org.github.bm.base.base.fegin.BaseFeign;
import org.github.bm.base.constant.AppConstant;
import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.feign.fallback.ResourcesClientFallback;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Time 2025-08-15 15:44
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@FeignClient(value = AppConstant.APPLICATION_SYSTEM_NAME, contextId = "resourcesClient", fallback = ResourcesClientFallback.class)
public interface IResourcesClient extends BaseFeign {
    String API_PREFIX = BASE_API_PREFIX + "/resources";
    String QUERY_PERMISSIONS_LIST_BY_USER_ID = API_PREFIX + "/queryPermissionsList";
    String QUERY_PERMISSIONS_VO_LIST_BY_USER_ID = API_PREFIX + "/queryPermissionsVoList";
    String QUERY_PERMISSIONS_TREE_BY_USER_ID = API_PREFIX + "/queryPermissionsTree";


    /**
     * 获取用户权限列表
     *
     * @param userId 用户id
     * @return 权限列表
     */
    @GetMapping(value = QUERY_PERMISSIONS_LIST_BY_USER_ID)
    List<ResourcesEntity> queryPermissionsListByUserId(@RequestParam("userId") Long userId);

    /**
     * 获取用户权限列表 to ResourcesVo
     *
     * @param userId 用户id
     * @return 权限列表
     */
    @GetMapping(value = QUERY_PERMISSIONS_VO_LIST_BY_USER_ID)
    List<ResourcesVO> queryPermissionsVoListByUserId(@RequestParam("userId") Long userId);

    /**
     * 获取用户权限树
     *
     * @param userId 用户id
     * @return 权限树
     */
    @GetMapping(value = QUERY_PERMISSIONS_TREE_BY_USER_ID)
    List<ResourcesTreeVO> queryPermissionsTreeByUserId(@RequestParam("userId") Long userId);
}
