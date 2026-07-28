package org.github.bm.resource.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.base.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.base.base.response.ApiResponse;
import org.github.bm.base.base.web.BaseController;
import org.github.bm.resource.dto.DataSourceAddInputDTO;
import org.github.bm.resource.dto.DataSourceEditInputDTO;
import org.github.bm.resource.dto.DataSourcePageQueryInputDTO;
import org.github.bm.resource.service.IDataSourceService;
import org.github.bm.resource.vo.DataSourceVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "数据源接口")
@RestController
@RequestMapping("/dataSource")
public class DataSourceController extends BaseController {

    @Resource
    IDataSourceService dataSourceService;

    @Operation(summary = "分页查询", description = "分页查询角色接口")
    @GetMapping(value = "/pageQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<Page<DataSourceVO>> pageQueryList(DataSourcePageQueryInputDTO inputDTO) {
        return ApiResponse.ok(dataSourceService.pageQueryList(inputDTO));
    }

    @Operation(summary = "添加数据源")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "该字典类型已存在")
    @PostMapping(value = "/addDataSource", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addDataSource(@RequestBody @Validated DataSourceAddInputDTO inputDTO) {
        return ApiResponse.ok(dataSourceService.addDataSource(inputDTO));
    }

    @Operation(summary = "编辑数据源")
    @PatchMapping(value = "/editDataSource", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> editDataSource(@RequestBody @Validated DataSourceEditInputDTO inputDTO) {
        return ApiResponse.ok(dataSourceService.editDataSource(inputDTO));
    }

    @Operation(summary = "删除数据源")
    @DeleteMapping(value = "/delDataSource", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delDataSource(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(dataSourceService.delDataSource(inputDTO));
    }
}
