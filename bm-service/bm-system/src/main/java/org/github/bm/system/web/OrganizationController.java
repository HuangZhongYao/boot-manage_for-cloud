package org.github.bm.system.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.system.dto.AddOrganizationInputDTO;
import org.github.bm.system.dto.EditOrganizationInputDTO;
import org.github.bm.system.dto.OrganizationPageQueryInputDTO;
import org.github.bm.system.service.IOrganizationService;
import org.github.bm.system.vo.OrganizationVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "组织架构")
@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    @Resource
    IOrganizationService organizationService;

    @Operation(summary = "分页查询", description = "分页查询组织架构接口")
    @GetMapping(value = "/pageQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<Page<OrganizationVO>> pageQueryList(OrganizationPageQueryInputDTO inputDTO) {
        return ApiResponse.ok(organizationService.pageQueryList(inputDTO));
    }

    @Operation(summary = "添加组织架构", description = "添加组织架构接口")
    @PostMapping(value = "/addOrganization", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addOrganization(@RequestBody @Validated AddOrganizationInputDTO inputDTO) {
        return ApiResponse.ok(organizationService.addOrganization(inputDTO));
    }

    @Operation(summary = "编辑组织架构", description = "编辑组织架构接口")
    @PatchMapping(value = "/editOrganization", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> editOrganization(@RequestBody @Validated EditOrganizationInputDTO inputDTO) {
        return ApiResponse.ok(organizationService.editOrganization(inputDTO));
    }

    @Operation(summary = "删除组织架构")
    @DeleteMapping(value = "/delOrganization", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delOrganization(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(organizationService.delOrganization(inputDTO));
    }
}
