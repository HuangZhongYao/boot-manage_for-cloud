package org.github.bm.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.util.ModelMapperUtil;
import org.github.bm.example.dto.AddBusTruckInputDTO;
import org.github.bm.example.dto.BusTruckQueryPageInputDTO;
import org.github.bm.example.dto.EditBusTruckInputDTO;
import org.github.bm.example.entity.BusTruckEntity;
import org.github.bm.example.repository.BusTruckRepository;
import org.github.bm.example.service.IBusTruckService;
import org.github.bm.example.vo.BusTruckVO;
import org.springframework.stereotype.Service;

/**
 * 车辆表Service服务接口实现层
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 20:23:37
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Service
@AllArgsConstructor
public class IBusTruckServiceImpl implements IBusTruckService {

    @Resource
    BusTruckRepository busTruckRepository;

    @Override
    public Page<BusTruckVO> pageQueryList(BusTruckQueryPageInputDTO inputDTO) {

        // 构建查询条件
        LambdaQueryWrapper<BusTruckEntity> queryWrapper = Wrappers.<BusTruckEntity>lambdaQuery();

        // 执行查询用户
        Page<BusTruckVO> page = busTruckRepository.selectPage(inputDTO.toMybatisPageObject(), queryWrapper, BusTruckVO.class);

        return page;
    }


    @Override
    public Boolean delBusTruck(BaseManyLongIdInputDTO inputDTO) {

        // 删除用户
        busTruckRepository.deleteByIds(inputDTO.getIds());
        return true;
    }

    @Override
    public Boolean addBusTruck(AddBusTruckInputDTO inputDTO) {

        // 将DTO转换为实体对象
        BusTruckEntity addEntity = ModelMapperUtil.map(inputDTO, BusTruckEntity.class);
        // 插入数据库
        busTruckRepository.insert(addEntity);

        return true;
    }

    @Override
    public Boolean editBusTruck(EditBusTruckInputDTO inputDTO) {

        // 更新的数据
        BusTruckEntity updateEntity = ModelMapperUtil.map(inputDTO, BusTruckEntity.class);

        // 执行更新
        busTruckRepository.updateById(updateEntity);

        return true;
    }

}
