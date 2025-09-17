package org.github.bm.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.example.dto.AddBusOrderInputDTO;
import org.github.bm.example.dto.BusOrderQueryPageInputDTO;
import org.github.bm.example.dto.EditBusOrderInputDTO;
import org.github.bm.example.vo.BusOrderVO;


/**
 * 商城订单表Service服务接口层
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 10:03:05
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
public interface IBusOrderService {

    Boolean addBusOrder(AddBusOrderInputDTO inputDTO);

    Boolean delBusOrder(BaseManyLongIdInputDTO inputDTO);

    Boolean editBusOrder(EditBusOrderInputDTO inputDTO);

    Page<BusOrderVO> pageQueryList(BusOrderQueryPageInputDTO inputDTO);
}
