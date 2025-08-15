package org.github.bm.system.feign;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.common.util.tree.ITreeNode;
import org.github.bm.common.util.tree.TreeUtil;
import org.github.bm.system.converter.ResourcesConverter;
import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.entity.RoleResourcesEntity;
import org.github.bm.system.entity.UserRoleEntity;
import org.github.bm.system.repository.ResourcesRepository;
import org.github.bm.system.repository.RoleRepository;
import org.github.bm.system.repository.RoleResourcesRepository;
import org.github.bm.system.repository.UserRoleRepository;
import org.github.bm.system.vo.ResourcesTreeVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Time 2025-08-15 16:29
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Hidden
@RestController
public class ResourcesClient implements IResourcesClient {

    @Resource
    ResourcesRepository resourcesRepository;
    @Resource
    UserRoleRepository userRoleRepository;
    @Resource
    RoleResourcesRepository roleResourcesRepository;
    @Resource
    ResourcesConverter resourcesConverter;


    @GetMapping(value = QUERY_PERMISSIONS_LIST_BY_USER_ID)
    public List<ResourcesEntity> queryPermissionsListByUserId(@RequestParam("userId") Long userId) {
        // TODO 如果有超级管理员角色拥有全部权限
//        if (StpUtil.getRoleList().contains(RoleConstant.SUPER_ADMIN_CODE)) {
//            return resourcesRepository.selectList(null);
//        }
        // 用户角色id集合
        List<Long> userRoleIds = userRoleRepository.selectList(Wrappers.<UserRoleEntity>lambdaQuery().eq(UserRoleEntity::getUserId, userId)).stream().map(UserRoleEntity::getRoleId).toList();

        if (userRoleIds.isEmpty()) {
            return new ArrayList<>();
        }

        // 角色的权限id集合
        List<Long> roleResourcesList = roleResourcesRepository.selectList(Wrappers.<RoleResourcesEntity>lambdaQuery().in(RoleResourcesEntity::getRoleId, userRoleIds)).stream().map(RoleResourcesEntity::getResourcesId).toList();

        if (roleResourcesList.isEmpty()) {
            return new ArrayList<>();
        }
        return resourcesRepository.selectList(Wrappers.<ResourcesEntity>lambdaQuery().in(ResourcesEntity::getId, roleResourcesList));
    }


    @GetMapping(value = QUERY_PERMISSIONS_TREE_BY_USER_ID)
    public List<ResourcesTreeVo> queryPermissionsTreeByUserId(@RequestParam("userId") Long userId) {
        // 获取用户权限列表
        List<ResourcesTreeVo> resourcesVos = resourcesConverter.toResourcesTreeVoList(this.queryPermissionsListByUserId(userId));
        // 转换ITreeNode List
        List<ITreeNode<Long>> treeNodeList = new ArrayList<>(resourcesVos.size());
        treeNodeList.addAll(resourcesVos);
        // 转换成树结构
        List<ITreeNode<Long>> tree = TreeUtil.listToTree(treeNodeList);
        return resourcesConverter.treeNodeToResourcesTreeVoList(tree);
    }
}
