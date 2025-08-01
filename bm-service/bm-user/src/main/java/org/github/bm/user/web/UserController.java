package org.github.bm.user.web;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.common.security.AuthUser;
import org.github.bm.common.security.SecurityContextHolder;
import org.github.bm.common.validate.group.Group;
import org.github.bm.system.vo.RoleVo;
import org.github.bm.user.dto.*;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.enums.GenderEnum;
import org.github.bm.user.feign.IUserClient;
import org.github.bm.user.repositery.UserRepository;
import org.github.bm.user.service.IUserService;
import org.github.bm.user.vo.UserVo;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Tag(name = "用户接口")
@RestController
@RequestMapping(IUserClient.API_PREFIX)
public class UserController extends BaseController {

    @Resource
    SnowflakeGenerator snowflakeGenerator;
    @Resource
    UserRepository userRepository;
    @Resource
    IUserService userService;

    @Operation(summary = "分页查询", description = "分页查询用户接口")
    @GetMapping(value = "/pageQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<Page<UserVo>> pageQueryList(UserQueryPageInputDTO inputDTO) {
        return ApiResponse.ok(userService.pageQueryList(inputDTO));
    }

    @Operation(summary = "查询全部用户", description = "查询全部用户接口")
    @GetMapping(value = "/queryAllUserList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<List<UserVo>> queryAllUserList() {
        return ApiResponse.ok(userService.queryAllUserList());
    }

    @Operation(summary = "获取用户的角色列表", description = "获取当前用户的角色列表")
    @GetMapping(value = "/queryUserRoleList", produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameters({
            @Parameter(name = "id", description = "用户id"),
    })
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<List<RoleVo>> queryCurrentUserList(@RequestParam(name = "id", required = true) Long id) {
        return ApiResponse.ok(userService.queryUserRoleList(id));
    }

    @Operation(summary = "添加用户", description = "添加用户接口")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "411", description = "账号已存在")
    @PostMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addUser(@RequestBody @Validated(Group.Insert.class) AddUserInputDTO inputDTO) {
        return ApiResponse.ok(userService.addUser(inputDTO));
    }

    @Operation(summary = "删除用户")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping(value = "/delUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delUser(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(userService.delUser(inputDTO));
    }

    @Operation(summary = "编辑用户", description = "编辑用户接口")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @PatchMapping(value = "/editUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addUser(@RequestBody @Validated EditUserInputDTO inputDTO) {
        return ApiResponse.ok(userService.editUser(inputDTO));
    }

    @Operation(summary = "启用|停用用户", description = "启用|停用用户接口")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @PatchMapping(value = "/setState", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> setState(@RequestBody @Validated SetUserStateInputDTO inputDTO) {
        return ApiResponse.ok(userService.setState(inputDTO));
    }

    @Operation(summary = "分配角色", description = "给用户分配角色")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @PatchMapping(value = "/setRole", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addUser(@RequestBody @Validated SetRoleInputDTO inputDTO) {
        return ApiResponse.ok(userService.setRole(inputDTO));
    }

    @Operation(summary = "重置密码", description = "管理员操作的")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @PatchMapping(value = "/resetPassword", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> resetPassword(@RequestBody @Validated ResetPasswordInputDTO inputDTO) {
        return ApiResponse.ok(userService.resetPassword(inputDTO));
    }

    @Operation(summary = "修改密码", description = "用户自己操作的")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "420", description = "OK")
    @PatchMapping(value = "/changePassword", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> changePassword(@RequestBody @Validated ChangePasswordInputDTO inputDTO) {
        return ApiResponse.ok(userService.changePassword(inputDTO));
    }

    @Operation(summary = "根据Id获取用户")
    @GetMapping("/getById")
    public Object getByid() {
        ArrayList<Long> longs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            longs.add(snowflakeGenerator.next());
        }
        List<UserEntity> userEntities = userRepository.selectList(new QueryWrapper<UserEntity>().eq("1", "1"));
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("adf", longs);
        stringObjectHashMap.put("adfsdfsd", userEntities);
        return stringObjectHashMap;
    }

    @Operation(summary = "根据Id获取用户")
    @PostMapping("/save")
    public ApiResponse<Boolean> save() {
        UserEntity userEntity = UserEntity.builder().account("xxxxxxx45454").phone("17685306043").password("dfsdfsdfsdfsd").enable(Boolean.TRUE).avatarUrl("34234").gender(GenderEnum.MALE).username("7878").build();
        int insert = userRepository.insert(userEntity);
        AuthUser authUser = SecurityContextHolder.getAuthUser();
        return ApiResponse.ok(insert > 0);
    }
}
