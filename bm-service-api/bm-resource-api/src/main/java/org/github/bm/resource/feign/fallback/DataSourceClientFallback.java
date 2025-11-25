package org.github.bm.resource.feign.fallback;

import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.feign.IDataSourceClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Time 2025-09-01 16:59
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class DataSourceClientFallback implements IDataSourceClient {
    /**
     * 获取全部数据源
     *
     * @return DataSourceVO
     */
    @Override
    public List<DataSourceEntity> getDataSourceAll() {
        return List.of();
    }

    @Override
    public boolean deleteDataSourceTest() {
        return false;
    }
}
