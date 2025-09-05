package org.github.bm.system.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.system.dto.*;
import org.github.bm.system.service.IDictService;
import org.github.bm.system.vo.DictDataVO;
import org.github.bm.system.vo.DictTypeTreeVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典模块控制器
 *
 * @Desc Created by IntelliJ IDEA.
 * @Author ZhongYao.Huang (https://github.com/HuangZhongYao)
 * @Copyright ZuuuuYao By Github
 * @Time 2024-08-18 4:06
 */
@Tag(name = "字典接口")
@AllArgsConstructor
@RestController
@RequestMapping("/dict")
public class DictionaryController extends BaseController {

    IDictService dictService;

    @Operation(summary = "获取字典类型Tree", description = "获取字典类型Tree结构接口")
    @GetMapping(value = "/dictTypeTree", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<DictTypeTreeVO>> dictTypeTree() {
        return ApiResponse.ok(dictService.dictTypeTree());
    }

    @Operation(summary = "添加字典类型", description = "添加字典类型接口")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "该字典类型已存在")
    @PostMapping(value = "/addDictType", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addDictType(@RequestBody @Validated AddDictTypeInputDTO inputDTO) {
        return ApiResponse.ok(dictService.addDictType(inputDTO));
    }

    @Operation(summary = "删除字典类型", description = "根据id删除接口")
    @DeleteMapping(value = "/delDictType", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delDictType(
        @RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(dictService.delDictType(inputDTO));
    }

    @Operation(summary = "编辑字典类型", description = "编辑字典类型接口")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "该字典类型已存在")
    @PatchMapping(value = "/editDictType", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addDictType(@RequestBody @Validated EditDictTypeInputDTO inputDTO) {
        return ApiResponse.ok(dictService.editDictType(inputDTO));
    }

    @Operation(summary = "启用|禁用字典类型", description = "启用|禁用字典类型接口")
    @PatchMapping(value = "/setStateDictType", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> setStateDictType(
        @RequestBody @Validated SetStateDictInputDTO inputDTO) {
        return ApiResponse.ok(dictService.setStateDictType(inputDTO));
    }

    @Operation(summary = "获取全部字典数据")
    @GetMapping(value = "/allDictDataQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<DictDataVO>> allDictDataQueryList() {
        return ApiResponse.ok(dictService.allDictDataQueryList());
    }

    @Operation(summary = "字典类型id获取字典数据", description = "根据字典类型id获取数据")
    @GetMapping(value = "/dictDataQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<DictDataVO>> dictDataQueryList(
        @RequestParam(name = "dictTypeId") Long dictTypeId) {
        return ApiResponse.ok(dictService.dictDataQueryList(dictTypeId));
    }

    @Operation(summary = "字典类型code获取字典数据", description = "根据字典类型code获取数据")
    @GetMapping(value = "/dictDataQueryListByDictTypeCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<DictDataVO>> dictDataQueryListByDictTypeCode(
            @RequestParam(name = "dictTypeCode") String dictTypeCode) {
        return ApiResponse.ok(dictService.dictDataQueryListByDictTypeCode(dictTypeCode));
    }

    @Operation(summary = "添加字典数据", description = "添加字典数据接口")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "该字典编码已存在")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "451", description = "该字典名称已存在")
    @PostMapping(value = "/addDictData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addDictData(@RequestBody @Validated AddDictInputDTO inputDTO) {
        return ApiResponse.ok(dictService.addDictData(inputDTO));
    }

    @Operation(summary = "删除字典数据", description = "删除字典数据接口")
    @DeleteMapping(value = "/delDictData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delDictData(
        @RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(dictService.delDictData(inputDTO));
    }

    @Operation(summary = "编辑字典数据", description = "编辑字典接口")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "450", description = "该字典编码已存在")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "451", description = "该字典名称已存在")
    @PatchMapping(value = "/editDictData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> editDictData(@RequestBody @Validated EditDictInputDTO inputDTO) {
        return ApiResponse.ok(dictService.editDictData(inputDTO));
    }

    @Operation(summary = "启用|禁用字典数据", description = "启用|禁用字典数据接口")
    @PatchMapping(value = "/setStateDictData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> setStateDictData(
        @RequestBody @Validated SetStateDictInputDTO inputDTO) {
        return ApiResponse.ok(dictService.setStateDictData(inputDTO));
    }
}
