package org.github.bm.system.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.feign.fallback.OrganizationClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Time 2025-09-01 16:18
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@FeignClient(value = AppConstant.APPLICATION_SYSTEM_NAME, contextId = "organizationClient",fallback = OrganizationClientFallback.class)
public interface IOrganizationClient extends BaseFeign {
    String API_PREFIX = BASE_API_PREFIX + "/organization";
    String GET_ORGANIZATION_AND_SUB_ORGANIZATION = API_PREFIX + "/getOrganizationAndSubOrganization";

    /**
     * 获取组织及子组织列表
     * @param organizationId 组织ID
     * @return 当前组织及子组织列表
     */
    @GetMapping(GET_ORGANIZATION_AND_SUB_ORGANIZATION)
    List<OrganizationEntity> getOrganizationAndSubOrganization(@RequestParam("organizationId")Long organizationId);
}
