package org.github.bm.system.feign.fallback;

import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.feign.IResourcesClient;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Time 2025-09-01 16:32
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class ResourcesClientFallback implements IResourcesClient {
    /**
     * 获取用户权限列表
     *
     * @param userId 用户id
     * @return 权限列表
     */
    @Override
    public List<ResourcesEntity> queryPermissionsListByUserId(Long userId) {
        return List.of();
    }

    /**
     * 获取用户权限列表 to ResourcesVo
     *
     * @param userId 用户id
     * @return 权限列表
     */
    @Override
    public List<ResourcesVO> queryPermissionsVoListByUserId(Long userId) {
        return List.of();
    }

    /**
     * 获取用户权限树
     *
     * @param userId 用户id
     * @return 权限树
     */
    @Override
    public List<ResourcesTreeVO> queryPermissionsTreeByUserId(Long userId) {
        return List.of();
    }
}
