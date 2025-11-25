package org.github.bm.resource.feign;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.resource.converter.DataSourceConverter;
import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.repository.DataSourceRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Hidden
@RestController
public class DataSourceClient implements IDataSourceClient {
    @Resource
    private DataSourceRepository dataSourceRepository;
    @Resource
    private DataSourceConverter dataSourceConverter;

    @Override
    @GetMapping(GET_DATASOURCE_ALL)
    public List<DataSourceEntity> getDataSourceAll() {
        return dataSourceRepository.selectList(null);
    }

    @Override
    @Transactional
    @DeleteMapping(DEL_DATASOURCE_TEST)
    public boolean deleteDataSourceTest() {
        return dataSourceRepository.deleteById(1) > 0;
    }
}
