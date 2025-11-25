package org.github.bm.example.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.example.dto.AddBusOrderInputDTO;
import org.github.bm.example.dto.AddBusTruckInputDTO;
import org.github.bm.example.service.IBusOrderService;
import org.github.bm.example.service.IBusTruckService;
import org.github.bm.resource.feign.IDataSourceClient;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.IUserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 演示使用seata分布式事务
 * Time 2025-11-18 16:14
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Slf4j
@Tag(name = "演示seata分布式事务")
@RestController
@RequestMapping("/test/transactions/")
@RequiredArgsConstructor
public class ExampleGlobalTransactionsController {
    private final IDataSourceClient dataSourceClient;
    private final IUserClient userClient;
    private final IBusOrderService busOrderService;
    private final IBusTruckService busTruckService;

    @GetMapping
    @GlobalTransactional
    public ApiResponse<String> exampleGlobalTransactions() throws InterruptedException {
        UserEntity userEntity = userClient.getUserByID(Long.valueOf("1"));
        System.out.println("userEntity = " + userEntity);
        Thread.sleep(5000);
        // 添加订单 事务参与者bm-example服务
        busOrderService.addBusOrder(AddBusOrderInputDTO
                .builder()
                .orderNo("741245test")
                .address("GlobalTransactionaltest")
                .consignee("GlobalTransactional")
                .commodity("GlobalTransactional")
                .orderTime(LocalDateTime.now())
                .payState((byte) 1)
                .consigneePhone("GlobalTransactional")
                .build());
        // 添加车辆 事务参与者bm-example服务
        busTruckService.addBusTruck(AddBusTruckInputDTO
                .builder()
                .brand("GlobalTransactional")
                .engineNo("GlobalTransactional")
                .fileNo("GlobalTransactional")
                .issuers("GlobalTransactional")
                .model("GlobalTransactional")
                .owner("GlobalTransactional")
                .plateNo("GlobalTransactional")
                .quality(100)
                .regDate(LocalDateTime.now())
                .useCharacter("GlobalTransactional")
                .vehicleType("GlobalTransactional")
                .vin("GlobalTransactional")
                .build());

        // 删除测试数据源 事务参与者bm-resource服务
        dataSourceClient.deleteDataSourceTest();
        // 随机触发异常
        if (System.currentTimeMillis() % 2 == 0) {
            throw new UserFriendlyException("模拟分布式事务异常");
        }
        return ApiResponse.ok("ok");
    }
}
