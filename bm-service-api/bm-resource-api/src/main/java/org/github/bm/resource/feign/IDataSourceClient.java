package org.github.bm.resource.feign;

import org.github.bm.base.base.fegin.BaseFeign;
import org.github.bm.base.constant.AppConstant;
import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.feign.fallback.DataSourceClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = AppConstant.APPLICATION_RESOURCE_NAME, contextId = "dataSourceFeignClient",fallback = DataSourceClientFallback.class)
public interface IDataSourceClient extends BaseFeign {
    String BASE_PREFIX = BASE_API_PREFIX+"/datasource";
    String GET_DATASOURCE_ALL = BASE_PREFIX+"/getDataSourceAll";
    String DEL_DATASOURCE_TEST = BASE_PREFIX+"/deleteDataSourceTest";

    /**
     * 获取全部数据源
     * @return DataSourceVO
     */
    @GetMapping(GET_DATASOURCE_ALL)
    List<DataSourceEntity> getDataSourceAll();

    /**
     * 删除数据源 测试分布式事务
     * @return  Boolean
     */
    @DeleteMapping(DEL_DATASOURCE_TEST)
    boolean deleteDataSourceTest();
}
