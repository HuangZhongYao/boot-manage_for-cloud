package org.github.bm.system.repository;

import org.apache.ibatis.annotations.Param;
import org.github.bm.common.mybatis.BaseMapperExtension;
import org.github.bm.system.entity.OrganizationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrganizationRepository extends BaseMapperExtension<OrganizationEntity> {

    /**
     * 获取指定组织及子组织的id列表
     * @param organizationId 组织id
     * @return 指定组织及子组织的id列表
     */
    Set<Long> getOrganizationAndSubOrganizationId(@Param("organizationId") Long organizationId);

    /**
     * 获取指定组织及子组织的id列表
     * @param ids 组织id列表
     * @return 指定组织及子组织的id列表
     */
    Set<Long> getOrganizationAndSubOrganizationIdList(@Param("ids") List<Long> ids);
}
