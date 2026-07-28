package org.github.bm.example.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.base.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.base.base.response.ApiResponse;
import org.github.bm.example.dto.AddBusOrderInputDTO;
import org.github.bm.example.dto.BusOrderQueryPageInputDTO;
import org.github.bm.example.dto.EditBusOrderInputDTO;
import org.github.bm.example.service.IBusOrderService;
import org.github.bm.example.vo.BusOrderVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 商城订单表Controller层,接受处理请求
 *
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 10:03:05
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Tag(name = "商城订单接口")
@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class BusOrderController {

    @Resource
    IBusOrderService busOrderService;

    @Operation(summary = "分页查询", description = "分页查询商城订单接口}")
    @GetMapping(value = "/pageQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Page<BusOrderVO>> pageQueryList(BusOrderQueryPageInputDTO inputDTO) {
        return ApiResponse.ok(busOrderService.pageQueryList(inputDTO));
    }

    @Operation(summary = "添加商城订单", description = "添加商城订单接口")
    @PostMapping(value = "/addBusOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addBusOrder(@RequestBody @Validated AddBusOrderInputDTO inputDTO) {
        return ApiResponse.ok(busOrderService.addBusOrder(inputDTO));
    }

    @Operation(summary = "删除商城订单", description = "根据id删除接口")
    @DeleteMapping(value = "/delBusOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delBusOrder(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(busOrderService.delBusOrder(inputDTO));
    }

    @Operation(summary = "编辑商城订单", description = "编辑商城订单接口")
    @PatchMapping(value = "/editBusOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addBusOrder(@RequestBody @Validated EditBusOrderInputDTO inputDTO) {
        return ApiResponse.ok(busOrderService.editBusOrder(inputDTO));
    }
}
