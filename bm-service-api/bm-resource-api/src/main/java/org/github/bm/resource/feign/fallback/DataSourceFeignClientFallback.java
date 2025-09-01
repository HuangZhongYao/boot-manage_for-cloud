package org.github.bm.resource.feign.fallback;

import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.feign.IDataSourceFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Time 2025-09-01 16:59
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class DataSourceFeignClientFallback implements IDataSourceFeignClient {
    /**
     * 获取全部数据源
     *
     * @return DataSourceVO
     */
    @Override
    public List<DataSourceEntity> getDataSourceAll() {
        return List.of();
    }
}
