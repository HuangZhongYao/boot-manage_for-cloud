package org.github.bm.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.bm.base.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.example.dto.AddBusTruckInputDTO;
import org.github.bm.example.dto.BusTruckQueryPageInputDTO;
import org.github.bm.example.dto.EditBusTruckInputDTO;
import org.github.bm.example.vo.BusTruckVO;

/**
 * 车辆表Service服务接口层
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 20:23:37
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
public interface IBusTruckService {

    Boolean addBusTruck(AddBusTruckInputDTO inputDTO);

    Boolean delBusTruck(BaseManyLongIdInputDTO inputDTO);

    Boolean editBusTruck(EditBusTruckInputDTO inputDTO);

    Page<BusTruckVO> pageQueryList(BusTruckQueryPageInputDTO inputDTO);
}
