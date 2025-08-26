package org.github.bm.resource.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.vo.DataSourceVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = AppConstant.APPLICATION_RESOURCE_NAME, contextId = "dataSourceFeignClient")
public interface IDataSourceFeignClient extends BaseFeign {
    String BASE_PREFIX = BASE_API_PREFIX+"/datasource";
    String GET_DATASOURCE_ALL = BASE_PREFIX+"/getDataSourceAll";

    /**
     * 获取全部数据源
     * @return DataSourceVO
     */
    @GetMapping(GET_DATASOURCE_ALL)
    List<DataSourceEntity> getDataSourceAll();
}
