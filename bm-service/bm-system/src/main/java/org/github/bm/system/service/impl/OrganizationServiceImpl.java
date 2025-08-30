package org.github.bm.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.system.converter.OrganizationConvert;
import org.github.bm.system.dto.AddOrganizationInputDTO;
import org.github.bm.system.dto.EditOrganizationInputDTO;
import org.github.bm.system.dto.OrganizationPageQueryInputDTO;
import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.repository.OrganizationRepository;
import org.github.bm.system.service.IOrganizationService;
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
    public Page<OrganizationVO> pageQueryList(OrganizationPageQueryInputDTO inputDTO) {
        // 构建查询条件
        LambdaQueryWrapper<OrganizationEntity> queryWrapper = Wrappers.<OrganizationEntity>lambdaQuery()
                .orderByDesc(OrganizationEntity::getCreatedTime)
                .like(StrUtil.isNotBlank(inputDTO.getKeyword()), OrganizationEntity::getName, inputDTO.getKeyword());
        // 执行查询
        Page<OrganizationEntity> page = organizationRepository.selectPage(inputDTO.toMybatisPageObject(), queryWrapper);
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
        if (this.organizationRepository.exists(Wrappers.<OrganizationEntity>lambdaQuery().eq(OrganizationEntity::getParentId, inputDTO.getParentId()).eq(OrganizationEntity::getName, inputDTO.getName()))) {
            throw new UserFriendlyException("名称已存在");
        }
        return this.organizationRepository.insert((organizationEntity)) > 0;
    }

    @Override
    public Boolean editOrganization(EditOrganizationInputDTO inputDTO) {
        // 查询库中的数据
        OrganizationEntity organizationEntityDB = this.organizationRepository.selectById(inputDTO.getId());
        // 更新的实体
        OrganizationEntity organizationUpdateEntity = organizationConvert.toEntity(inputDTO);
        // 判断名称是否存在
        if (this.organizationRepository.exists(Wrappers.<OrganizationEntity>lambdaQuery()
                .eq(OrganizationEntity::getParentId, inputDTO.getParentId())
                .eq(OrganizationEntity::getName, inputDTO.getName())
                .ne(OrganizationEntity::getName, organizationEntityDB.getName()))
        ) {
            throw new UserFriendlyException("名称已存在");
        }
        return this.organizationRepository.updateById((organizationUpdateEntity)) > 0;
    }

    @Override
    public Boolean delOrganization(BaseManyLongIdInputDTO inputDTO) {
        return this.organizationRepository.deleteByIds(inputDTO.getIds()) > 0;
    }
}
