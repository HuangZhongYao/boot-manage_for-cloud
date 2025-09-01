package org.github.bm.system.feign.fallback;

import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.feign.IOrganizationClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Time 2025-09-01 16:27
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class OrganizationClientFallback implements IOrganizationClient {
    /**
     * 获取组织及子组织列表
     *
     * @param organizationId 组织ID
     * @return 当前组织及子组织列表
     */
    @Override
    public List<OrganizationEntity> getOrganizationAndSubOrganization(Long organizationId) {
        return List.of();
    }

    @Override
    public List<OrganizationEntity> getOrganizationByIds(List<Long> ids) {
        return List.of();
    }
}
