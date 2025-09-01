package org.github.bm.system.feign;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.service.IOrganizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Time 2025-09-01 16:35
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Hidden
@RestController
public class OrganizationClient implements IOrganizationClient{
    @Resource
    private IOrganizationService organizationService;

    /**
     * 获取组织及子组织列表
     *
     * @param organizationId 组织ID
     * @return 当前组织及子组织列表
     */
    @Override
    @GetMapping(GET_ORGANIZATION_AND_SUB_ORGANIZATION)
    public List<OrganizationEntity> getOrganizationAndSubOrganization(Long organizationId) {
        return organizationService.queryOrganizationAndSubOrganization(organizationId);
    }
}
