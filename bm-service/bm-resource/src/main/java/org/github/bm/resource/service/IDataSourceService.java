package org.github.bm.resource.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.resource.dto.DataSourceAddInputDTO;
import org.github.bm.resource.dto.DataSourceEditInputDTO;
import org.github.bm.resource.dto.DataSourcePageQueryInputDTO;
import org.github.bm.resource.entity.DataSourceEntity;
import org.github.bm.resource.vo.DataSourceVO;

public interface IDataSourceService extends IService<DataSourceEntity> {
    /**
     * 分页查询数据源列表
     * @param inputDTO 数据源分页查询条件输入参数
     * @return 数据源分页查询结果，包含数据源信息列表和分页信息
     */
    Page<DataSourceVO> pageQueryList(DataSourcePageQueryInputDTO inputDTO);

    /**
     * 添加数据源
     * @param inputDTO 数据源添加输入参数，包含数据源的基本信息
     * @return 添加结果，true表示添加成功，false表示添加失败
     */
    Boolean addDataSource(DataSourceAddInputDTO inputDTO);

    /**
     * 编辑数据源
     * @param inputDTO 数据源编辑输入参数，包含数据源的更新信息
     * @return 编辑结果，true表示编辑成功，false表示编辑失败
     */
    Boolean editDataSource(DataSourceEditInputDTO inputDTO);

    /**
     * 删除数据源
     * @param inputDTO 数据源删除输入参数，包含数据源的ID
     * @return 删除结果，true表示删除成功，false表示删除失败
     */
    Boolean delDataSource(BaseManyLongIdInputDTO inputDTO);
}
