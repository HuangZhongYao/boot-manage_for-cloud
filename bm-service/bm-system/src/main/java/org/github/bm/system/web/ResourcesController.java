package org.github.bm.system.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.system.dto.AddResourcesInputDTO;
import org.github.bm.system.dto.EditResourcesInputDTO;
import org.github.bm.system.dto.SetResourcesStateInputDTO;
import org.github.bm.system.service.IResourcesService;
import org.github.bm.system.vo.ResourcesTreeVo;
import org.github.bm.system.vo.ResourcesVo;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源接口控制器
 *
 * @Desc
 * @Time 2024-07-11 16:32
 * @Author HuangZhongYao
 */
@Tag(name = "资源接口", description = "菜单资源模块接口")
@RestController
@RequestMapping("/resources")
@AllArgsConstructor
public class ResourcesController extends BaseController {

    IResourcesService resourcesService;

    @Operation(summary = "查询资源下按钮", description = "查询资源下的按钮")
    @GetMapping(value = "/button/{parentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<List<ResourcesVo>> button(@PathVariable(name = "parentId", required = true) Long parentId) {
        return ApiResponse.ok(resourcesService.button(parentId));
    }

    @GetMapping(value = "/resourcesTree", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "查询资源树", description = "查询资源树返回全部资源")
    public ApiResponse<List<ResourcesTreeVo>> resourcesTree() {
        return ApiResponse.ok(resourcesService.resourcesTree());
    }

    @Operation(summary = "添加资源", description = "添加资源接口")

    @PostMapping(value = "/addResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addResources(@RequestBody @Validated AddResourcesInputDTO inputDTO) {
        return ApiResponse.ok(resourcesService.addResources(inputDTO));
    }

    @Operation(summary = "编辑资源", description = "编辑资源接口")
    @PatchMapping(value = "/editResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> editResources(@RequestBody @Validated EditResourcesInputDTO inputDTO) {
        return ApiResponse.ok(resourcesService.editResources(inputDTO));
    }

    @Operation(summary = "启用|停用资源", description = "启用|停用资源接口")
    @PatchMapping(value = "/setState", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> setState(@RequestBody @Validated SetResourcesStateInputDTO inputDTO) {
        return ApiResponse.ok(resourcesService.setState(inputDTO));
    }

    @Operation(summary = "删除资源")
    @DeleteMapping(value = "/delResources", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delResources(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(resourcesService.delResources(inputDTO));
    }

}
