package org.github.bm.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;

import java.util.*;
import java.util.stream.Collectors;

import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.common.util.ModelMapperUtil;
import org.github.bm.common.util.tree.ITreeNode;
import org.github.bm.common.util.tree.TreeUtil;
import org.github.bm.system.converter.OrganizationConvert;
import org.github.bm.system.dto.AddOrganizationInputDTO;
import org.github.bm.system.dto.EditOrganizationInputDTO;
import org.github.bm.system.dto.OrganizationPageQueryInputDTO;
import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.repository.OrganizationRepository;
import org.github.bm.system.service.IOrganizationService;
import org.github.bm.system.vo.OrganizationTreeVO;
import org.github.bm.system.vo.OrganizationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements IOrganizationService {
    @Resource
    private OrganizationRepository organizationRepository;
    @Resource
    private OrganizationConvert organizationConvert;

    @Override
    public List<OrganizationTreeVO> organizationTree() {
        // 查询全部组织
        List<OrganizationTreeVO> organizationTreeVOList = this.organizationRepository.selectList(
            Wrappers.<OrganizationEntity>lambdaQuery().orderByAsc(OrganizationEntity::getSort),
            OrganizationTreeVO.class);
        // 转换ITreeNode List
        List<ITreeNode<Long>> treeNodeList = new ArrayList<>(organizationTreeVOList.size());
        treeNodeList.addAll(organizationTreeVOList);
        // 转换树结构
        List<ITreeNode<Long>> tree = TreeUtil.listToTree(treeNodeList);
        // 转换OrganizationTreeVO List
        return ModelMapperUtil.mapList(tree, OrganizationTreeVO.class);
    }

    @Override
    public Page<OrganizationVO> pageQueryList(OrganizationPageQueryInputDTO inputDTO) {
        // 构建查询条件
        LambdaQueryWrapper<OrganizationEntity> queryWrapper =
            Wrappers.<OrganizationEntity>lambdaQuery()
                .orderByDesc(OrganizationEntity::getCreatedTime)
                .like(StrUtil.isNotBlank(inputDTO.getKeyword()), OrganizationEntity::getName,
                    inputDTO.getKeyword());
        // 执行查询
        Page<OrganizationEntity> page =
            organizationRepository.selectPage(inputDTO.toMybatisPageObject(), queryWrapper);
        // 构建返回值
        Page<OrganizationVO> pageVO = new Page<>();
        BeanUtils.copyProperties(page, pageVO);
        pageVO.setRecords(organizationConvert.toVOList(page.getRecords()));
        return pageVO;
    }

    @Override
    public Boolean addOrganization(AddOrganizationInputDTO inputDTO) {
        OrganizationEntity organizationEntity = organizationConvert.toEntity(inputDTO);
        // 判断名称是否存在
        if (this.organizationRepository.exists(Wrappers.<OrganizationEntity>lambdaQuery()
            .or(wrapper -> wrapper.eq(OrganizationEntity::getId, inputDTO.getParentId())
                .or()
                .isNull(OrganizationEntity::getParentId))
            .eq(OrganizationEntity::getName, inputDTO.getName()))) {
            throw new UserFriendlyException("名称已存在");
        }
        return this.organizationRepository.insert((organizationEntity)) > 0;
    }

    @Override
    public Boolean editOrganization(EditOrganizationInputDTO inputDTO) {
        // 查询库中的数据
        OrganizationEntity organizationEntityDB =
            this.organizationRepository.selectById(inputDTO.getId());
        // 更新的实体
        OrganizationEntity organizationUpdateEntity = organizationConvert.toEntity(inputDTO);
        // 当名称有变动时判断名称是否存在
        if (!organizationEntityDB.getName().equals(inputDTO.getName()) && this.organizationRepository.exists(Wrappers.<OrganizationEntity>lambdaQuery()
            .or(wrapper -> wrapper.eq(OrganizationEntity::getId, inputDTO.getParentId())
                .or()
                .isNull(OrganizationEntity::getParentId))
            .eq(OrganizationEntity::getName, inputDTO.getName())
        )) {
            throw new UserFriendlyException("名称已存在");
        }
        return this.organizationRepository.updateById((organizationUpdateEntity)) > 0;
    }

    @Override
    public Boolean delOrganization(BaseManyLongIdInputDTO inputDTO) {
        return this.organizationRepository.deleteByIds(inputDTO.getIds()) > 0;
    }

    /**
     * 查询组织机构及其子组织机构
     * 根据指定ID查询该组织机构及其所有子组织机构
     *
     * @param id 组织机构ID
     * @return 组织机构实体列表，包含指定组织机构及其所有子组织机构
     */

    @Override
    public List<OrganizationEntity> queryOrganizationAndSubOrganization(Long id) {
        // 1. 查询所有组织
        List<OrganizationEntity> allOrganizationEntity = organizationRepository.selectList(null);

        if (allOrganizationEntity == null || allOrganizationEntity.isEmpty()) {
            return List.of();
        }

        // 2. 构建 id -> OrganizationEntity 映射，便于通过 parentId 查找子组织
        Map<Long, OrganizationEntity> orgMap = allOrganizationEntity.stream()
                .collect(Collectors.toMap(OrganizationEntity::getId, org -> org));

        // 3. 找到目标根组织
        OrganizationEntity rootOrg = orgMap.get(id);
        if (rootOrg == null) {
            return List.of();
        }

        // 4. 准备 BFS
        List<OrganizationEntity> result = new ArrayList<>();
        Queue<OrganizationEntity> queue = new LinkedList<>();

        // 根组织入队
        queue.offer(rootOrg);

        while (!queue.isEmpty()) {
            // 当前层节点数
            int levelSize = queue.size();
            // 当前层组织列表
            List<OrganizationEntity> currentLevel = new ArrayList<>(levelSize);

            // 取出当前层所有组织
            for (int i = 0; i < levelSize; i++) {
                OrganizationEntity org = queue.poll();
                currentLevel.add(org);
            }

            // 对当前层组织按 sort 升序排序，sort 相同可再按 id 排序（保证稳定）
            currentLevel.sort(Comparator.comparing(OrganizationEntity::getSort)
                    .thenComparing(OrganizationEntity::getId));

            // 加入最终结果（这一层就是同一层级，已排序）
            result.addAll(currentLevel);

            // 找出这些组织的所有子组织，加入下一层队列
            for (OrganizationEntity org : currentLevel) {
                Long currentId = org.getId(); // 当前组织的 id，作为 parentId
                for (OrganizationEntity candidate : orgMap.values()) {
                    if (candidate.getParentId() != null && candidate.getParentId().equals(currentId)) {
                        queue.offer(candidate);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 根据组织id列表查询组织
     *
     * @param ids 组织id列表
     * @return 组织列表
     */
    @Override
    public List<OrganizationEntity> queryOrganizationByIds(List<Long> ids) {
        return this.organizationRepository.selectList(Wrappers.<OrganizationEntity>lambdaQuery().in(OrganizationEntity::getId, ids));
    }
}
