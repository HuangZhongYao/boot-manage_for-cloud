package org.github.bm.system.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.base.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.base.base.response.ApiResponse;
import org.github.bm.base.base.web.BaseController;
import org.github.bm.system.dto.*;
import org.github.bm.system.service.IRoleService;
import org.github.bm.system.vo.RolePageQueryListItemVO;
import org.github.bm.system.vo.RoleUserModel;
import org.github.bm.system.vo.RoleVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 18:41
 */
@Tag(name = "角色接口")
@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Resource
    IRoleService roleService;

    @Operation(summary = "分页查询", description = "分页查询角色接口")
    @GetMapping(value = "/pageQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<Page<RolePageQueryListItemVO>> pageQueryList(RolePageQueryInputDTO inputDTO) {
        return ApiResponse.ok(roleService.pageQueryList(inputDTO));
    }

    @Operation(summary = "根据状态查询角色", description = "根据角色启用状态查询")
    @GetMapping(value = "/queryList", produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
        @Parameter(name = "enable", description = "true|false|不传递,true查询启用,false=查询禁用,不传入=查询全部"),
    })
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<List<RoleVO>> queryList(@RequestParam(name = "enable")Boolean enable) {
        return ApiResponse.ok(roleService.queryList(enable));
    }

    @Operation(summary = "查询角色下的用户", description = "查询指定角色下有哪些用户")
    @GetMapping(value = "/queryRoleUserList", produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
        @Parameter(name = "id", description = "角色id"),
    })
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<List<RoleUserModel>> queryRoleUserList(@RequestParam(name = "id") Long id) {
        return ApiResponse.ok(roleService.queryRoleUserList(id));
    }

    @Operation(summary = "角色设置用户", description = "批量给角色设置用户")
    @PostMapping(value = "/setRoleUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> setRoleUser(@RequestBody @Validated SetRoleUserInputDTO inputDTO) {
        return ApiResponse.ok(roleService.setRoleUser(inputDTO));
    }

    @Operation(summary = "添加角色")
    @PostMapping(value = "/addRole",produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addRole(@RequestBody @Validated AddRoleInputDTO inputDTO) {
        return ApiResponse.ok(roleService.addRole(inputDTO));
    }

    @Operation(summary = "编辑角色")
    @PatchMapping(value = "/editRole",produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> editRole(@RequestBody @Validated EditRoleInputDTO inputDTO) {
        return ApiResponse.ok(roleService.editRole(inputDTO));
    }

    @Operation(summary = "启用|停用角色", description = "启用|停用角色接口")
    @PatchMapping(value = "/setState", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> setState(@RequestBody @Validated SetRoleStateInputDTO inputDTO) {
        return ApiResponse.ok(roleService.setState(inputDTO));
    }

    @Operation(summary = "删除角色")
    @DeleteMapping(value = "/delRole", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delRole(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(roleService.delRole(inputDTO));
    }

}
