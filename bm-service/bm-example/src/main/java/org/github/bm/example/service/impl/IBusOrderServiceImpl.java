package org.github.bm.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.util.ModelMapperUtil;
import org.github.bm.example.dto.AddBusOrderInputDTO;
import org.github.bm.example.dto.BusOrderQueryPageInputDTO;
import org.github.bm.example.dto.EditBusOrderInputDTO;
import org.github.bm.example.entity.BusOrderEntity;
import org.github.bm.example.repository.BusOrderRepository;
import org.github.bm.example.service.IBusOrderService;
import org.github.bm.example.vo.BusOrderVO;
import org.springframework.stereotype.Service;

/**
 * 商城订单表Service服务接口实现层
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 10:03:05
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Service
@AllArgsConstructor
public class IBusOrderServiceImpl implements IBusOrderService {

    @Resource
    BusOrderRepository busOrderRepository;

    @Override
    public Page<BusOrderVO> pageQueryList(BusOrderQueryPageInputDTO inputDTO) {

        // 构建查询条件
        LambdaQueryWrapper<BusOrderEntity> queryWrapper = Wrappers.<BusOrderEntity>lambdaQuery();

        // 执行查询用户
        Page<BusOrderVO> page = busOrderRepository.selectPage(inputDTO.toMybatisPageObject(), queryWrapper, BusOrderVO.class);

        return page;
    }


    @Override
    public Boolean delBusOrder(BaseManyLongIdInputDTO inputDTO) {

        // 删除用户
        busOrderRepository.deleteByIds(inputDTO.getIds());
        return true;
    }

    @Override
    public Boolean addBusOrder(AddBusOrderInputDTO inputDTO) {

        // 将DTO转换为实体对象
        BusOrderEntity addEntity = ModelMapperUtil.map(inputDTO, BusOrderEntity.class);
        // 插入数据库
        busOrderRepository.insert(addEntity);

        return true;
    }

    @Override
    public Boolean editBusOrder(EditBusOrderInputDTO inputDTO) {

        // 更新的数据
        BusOrderEntity updateEntity = ModelMapperUtil.map(inputDTO, BusOrderEntity.class);

        // 执行更新
        busOrderRepository.updateById(updateEntity);

        return true;
    }

}
