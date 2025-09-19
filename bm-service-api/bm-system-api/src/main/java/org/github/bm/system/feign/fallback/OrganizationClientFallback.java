package org.github.bm.system.feign.fallback;

import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.feign.IOrganizationClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Time 2025-09-01 16:27
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class OrganizationClientFallback implements IOrganizationClient {
    @Override
    public Set<Long> getOrganizationAndSubOrganizationIdList(Long organizationId) {
        return Set.of();
    }

    @Override
    public Set<Long> getOrganizationAndSubOrganizationIdList(List<Long> ids) {
        return Set.of();
    }

    @Override
    public List<OrganizationEntity> getOrganizationAndSubOrganization(Long organizationId) {
        return List.of();
    }

    @Override
    public List<OrganizationEntity> getOrganizationByIds(List<Long> ids) {
        return List.of();
    }
}
