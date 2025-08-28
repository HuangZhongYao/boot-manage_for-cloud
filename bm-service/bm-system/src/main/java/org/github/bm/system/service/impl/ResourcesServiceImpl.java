package org.github.bm.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.enums.ResourcesTypeEnum;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.common.util.ModelMapperUtil;
import org.github.bm.common.util.tree.ITreeNode;
import org.github.bm.common.util.tree.TreeUtil;
import org.github.bm.system.dto.AddResourcesInputDTO;
import org.github.bm.system.dto.EditResourcesInputDTO;
import org.github.bm.system.dto.SetResourcesStateInputDTO;
import org.github.bm.system.entity.ResourcesEntity;
import org.github.bm.system.entity.RoleResourcesEntity;
import org.github.bm.system.repository.ResourcesRepository;
import org.github.bm.system.repository.RoleResourcesRepository;
import org.github.bm.system.service.IResourcesService;
import org.github.bm.system.vo.ResourcesTreeVO;
import org.github.bm.system.vo.ResourcesVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-14 2:33
 */
@AllArgsConstructor
@Service
public class ResourcesServiceImpl implements IResourcesService {

    ResourcesRepository resourcesRepository;
    RoleResourcesRepository roleResourcesRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean delResources(BaseManyLongIdInputDTO inputDTO) {

        // 删除资源关联角色中间表数据
        roleResourcesRepository.delete(Wrappers.<RoleResourcesEntity>lambdaQuery()
            .in(RoleResourcesEntity::getResourcesId, inputDTO.getIds()));
        // 删除资源
        resourcesRepository.deleteByIds(inputDTO.getIds());
        return true;
    }

    @Override
    public Boolean addResources(AddResourcesInputDTO inputDTO) {

        // 判断资源编码是否重复
        if (resourcesRepository.exists(Wrappers.<ResourcesEntity>lambdaQuery()
            .eq(ResourcesEntity::getCode, inputDTO.getCode()))) {
            throw new UserFriendlyException("资源编码已存在,换一个吧");
        }

        // DTO转换实体
        ResourcesEntity resourcesEntity =
            ModelMapperUtil.map(inputDTO, ResourcesEntity.class, (source, target) -> {
                target.setSort(source.getOrder());
                target.setIsShow(source.getShow());
            });

        // 插入数据库
        resourcesRepository.insert(resourcesEntity);

        return true;
    }

    @Override
    public Boolean editResources(EditResourcesInputDTO inputDTO) {

        // 数据库中的数据
        ResourcesEntity resourcesEntity = resourcesRepository.selectById(inputDTO.getId());

        // 修改了资源编码需要判断是否重复
        if (!resourcesEntity.getCode().equals(inputDTO.getCode())) {
            // 判断资源编码是否重复
            if (resourcesRepository.exists(Wrappers.<ResourcesEntity>lambdaQuery()
                .ne(ResourcesEntity::getCode, resourcesEntity.getCode())
                .eq(ResourcesEntity::getCode, inputDTO.getCode()))) {

                throw new UserFriendlyException("资源编码已存在,换一个吧!");
            }
        }

        // DTO转换实体
        ResourcesEntity updateEntity =
            ModelMapperUtil.map(inputDTO, ResourcesEntity.class, (source, target) -> {
                target.setSort(source.getOrder());
                target.setIsShow(source.getShow());
            });

        // 执行更新
        this.resourcesRepository.updateById(updateEntity);

        return true;
    }

    @Override
    public Boolean setState(SetResourcesStateInputDTO inputDTO) {

        ResourcesEntity updateEntity =
            ResourcesEntity.builder().enable(inputDTO.getState()).build();
        updateEntity.setId(inputDTO.getId());

        resourcesRepository.updateById(updateEntity);

        return true;
    }

    @Override
    public List<ResourcesVO> button(Long parentId) {
        // 查询条件
        LambdaQueryWrapper<ResourcesEntity> queryWrapper = Wrappers.<ResourcesEntity>lambdaQuery()
            .eq(ResourcesEntity::getParentId, parentId)
            .eq(ResourcesEntity::getType, ResourcesTypeEnum.BUTTON)
            .orderByAsc(ResourcesEntity::getSort);
        // 执行查询转换类型
        return this.resourcesRepository.selectList(queryWrapper, ResourcesVO.class);
    }

    @Override
    public List<ResourcesTreeVO> resourcesTree() {
        // 查询全部资源列表
        List<ResourcesTreeVO> resourcesVos =
            resourcesRepository.selectList(Wrappers.<ResourcesEntity>lambdaQuery().orderByAsc(ResourcesEntity::getSort), ResourcesTreeVO.class);
        // 转换ITreeNode List
        List<ITreeNode<Long>> treeNodeList = new ArrayList<>(resourcesVos.size());
        treeNodeList.addAll(resourcesVos);
        // 转换树结构
        List<ITreeNode<Long>> tree = TreeUtil.listToTree(treeNodeList);
        // 转换ResourcesTreeVo List
        return ModelMapperUtil.mapList(tree, ResourcesTreeVO.class);
    }
}
