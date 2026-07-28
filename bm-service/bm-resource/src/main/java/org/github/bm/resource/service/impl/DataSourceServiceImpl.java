package org.github.bm.resource.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.github.bm.base.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.base.exception.UserFriendlyException;
import org.github.bm.resource.converter.DataSourceConverter;
import org.github.bm.resource.dto.DataSourceAddInputDTO;
import org.github.bm.resource.dto.DataSourceEditInputDTO;
import org.github.bm.resource.dto.DataSourcePageQueryInputDTO;
import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.repository.DataSourceRepository;
import org.github.bm.resource.service.IDataSourceService;
import org.github.bm.resource.vo.DataSourceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DataSourceServiceImpl extends ServiceImpl<DataSourceRepository, DataSourceEntity> implements IDataSourceService {
    @Resource
    DataSourceRepository dataSourceRepository;
    @Resource
    DataSourceConverter dataSourceConverter;

    @Override
    public Page<DataSourceVO> pageQueryList(DataSourcePageQueryInputDTO inputDTO) {
        LambdaQueryWrapper<DataSourceEntity> wrapper = Wrappers.<DataSourceEntity>lambdaQuery().like(StrUtil.isNotBlank(inputDTO.getKeyword()), DataSourceEntity::getName, inputDTO.getKeyword());
        Page<DataSourceEntity> page = dataSourceRepository.selectPage(inputDTO.toMybatisPageObject(), wrapper);

        Page<DataSourceVO> pageVO = new Page<>();
        BeanUtils.copyProperties(page, pageVO);
        pageVO.setRecords(dataSourceConverter.toVOList(page.getRecords()));
        return pageVO;
    }

    @Override
    public Boolean addDataSource(DataSourceAddInputDTO inputDTO) {
        // 判断该数据源名称是否已存在
        if (dataSourceRepository.selectCount(Wrappers.<DataSourceEntity>lambdaQuery().eq(DataSourceEntity::getName, inputDTO.getName())) > 0) {
            throw new UserFriendlyException("数据源名称已存在");
        }
        DataSourceEntity entity = dataSourceConverter.toEntity(inputDTO);
        return this.dataSourceRepository.insert((entity)) > 0;
    }

    @Override
    public Boolean editDataSource(DataSourceEditInputDTO inputDTO) {
        // 库中数据源
        DataSourceEntity dataSourceDBEntity = dataSourceRepository.selectById(inputDTO.getId());
        // 检查数据源是否使用中
        if (!StrUtil.equals(inputDTO.getName(), dataSourceDBEntity.getName()) && dataSourceRepository.selectCount(Wrappers.<DataSourceEntity>lambdaQuery().eq(DataSourceEntity::getName, inputDTO.getName())) > 0) {
            throw new UserFriendlyException("数据源名称已存在");
        }
        DataSourceEntity entity = dataSourceConverter.toEntity(inputDTO);
        return this.dataSourceRepository.updateById(entity) > 0;
    }

    @Override
    public Boolean delDataSource(BaseManyLongIdInputDTO inputDTO) {
        return this.dataSourceRepository.deleteById(inputDTO.getIds()) > 0;
    }
}
