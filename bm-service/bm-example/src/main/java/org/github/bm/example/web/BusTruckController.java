package org.github.bm.example.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.example.dto.AddBusTruckInputDTO;
import org.github.bm.example.dto.BusTruckQueryPageInputDTO;
import org.github.bm.example.dto.EditBusTruckInputDTO;
import org.github.bm.example.service.IBusTruckService;
import org.github.bm.example.vo.BusTruckVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 车辆表Controller层,接受处理请求
 *
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 20:23:37
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Tag(name = "车辆接口")
@RestController
@RequestMapping("/bustruck")
@AllArgsConstructor
public class BusTruckController {

    @Resource
    IBusTruckService busTruckService;

    @Operation(summary = "分页查询", description = "分页查询车辆接口}")
    @GetMapping(value = "/pageQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Page<BusTruckVO>> pageQueryList(BusTruckQueryPageInputDTO inputDTO) {
        return ApiResponse.ok(busTruckService.pageQueryList(inputDTO));
    }

    @Operation(summary = "添加车辆", description = "添加车辆接口")
    @PostMapping(value = "/addBusTruck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addBusTruck(@RequestBody @Validated AddBusTruckInputDTO inputDTO) {
        return ApiResponse.ok(busTruckService.addBusTruck(inputDTO));
    }

    @Operation(summary = "删除车辆", description = "根据id删除接口")
    @DeleteMapping(value = "/delBusTruck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delBusTruck(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(busTruckService.delBusTruck(inputDTO));
    }

    @Operation(summary = "编辑车辆", description = "编辑车辆接口")
    @PatchMapping(value = "/editBusTruck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addBusTruck(@RequestBody @Validated EditBusTruckInputDTO inputDTO) {
        return ApiResponse.ok(busTruckService.editBusTruck(inputDTO));
    }
}
