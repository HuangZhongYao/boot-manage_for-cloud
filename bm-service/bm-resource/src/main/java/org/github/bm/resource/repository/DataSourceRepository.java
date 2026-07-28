package org.github.bm.resource.repository;

import org.github.bm.base.mybatis.BaseMapperExtension;
import org.github.bm.resource.entity.DataSourceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends BaseMapperExtension<DataSourceEntity> {
}
