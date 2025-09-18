package org.github.bm.common.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.override.MybatisMapperProxy;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.MybatisUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.github.bm.common.util.ModelMapperUtil;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * BaseMapper扩展 , 提供一些常用的方法查询结果并转换类型、批量插入更新
 *
 * @Desc BaseMapper扩展
 * @Time 2024-07-12 09:25
 * @Author HuangZhongYao
 */
public interface BaseMapperExtension<TEntity> extends BaseMapper<TEntity> {

    /**
     * 根据id查询并转换为指定类型
     *
     * @param id     id
     * @param uClass 转换目标类型
     * @param <U>    目标类型
     * @return 转换后类型结果
     */
    default <U> U selectById(Serializable id, Class<U> uClass) {
        TEntity entity = this.selectById(id);
        return ModelMapperUtil.map(entity, uClass);
    }

    /**
     * 根据id查询并转换为指定类型,然后进行函数处理
     *
     * @param id       id
     * @param uClass   转换目标类型
     * @param consumer 处理函数
     * @param <U>      目标类型
     * @return 转换后类型结果
     */
    default <U> U selectById(Serializable id, Class<U> uClass, Consumer<U> consumer) {
        TEntity entity = this.selectById(id);
        return ModelMapperUtil.map(entity, uClass, consumer);
    }

    /**
     * 根据id查询并转换为指定类型,然后进行函数处理
     *
     * @param id         id
     * @param uClass     转换目标类型
     * @param biConsumer 处理函数
     * @param <U>        目标类型
     * @return 转换后类型结果
     */
    default <U> U selectById(Serializable id, Class<U> uClass, BiConsumer<TEntity, U> biConsumer) {
        TEntity entity = this.selectById(id);
        return ModelMapperUtil.map(entity, uClass, biConsumer);
    }

    /**
     * 根据wrapper条件查询并转换为指定类型
     *
     * @param queryWrapper 查询条件
     * @param uClass       转换目标类型
     * @param <U>          目标类型
     * @return 转换后类型结果
     */
    default <U> U selectOne(Wrapper<TEntity> queryWrapper, Class<U> uClass) {
        TEntity entity = this.selectOne(queryWrapper);
        return ModelMapperUtil.map(entity, uClass);
    }

    /**
     * 根据wrapper条件查询并转换为指定类型,然后进行函数处理
     *
     * @param queryWrapper 查询条件
     * @param uClass       转换目标类型
     * @param consumer     处理函数
     * @param <U>          目标类型
     * @return 转换后类型结果
     */
    default <U> U selectOne(Wrapper<TEntity> queryWrapper, Class<U> uClass, Consumer<U> consumer) {
        TEntity entity = this.selectOne(queryWrapper);
        return ModelMapperUtil.map(entity, uClass, consumer);
    }

    /**
     * 根据wrapper条件查询并转换为指定类型,然后进行函数处理
     *
     * @param queryWrapper 查询条件
     * @param uClass       转换目标类型
     * @param biConsumer   处理函数
     * @param <U>          目标类型
     * @return 转换后类型结果
     */
    default <U> U selectOne(Wrapper<TEntity> queryWrapper, Class<U> uClass,
                            BiConsumer<TEntity, U> biConsumer) {
        TEntity entity = this.selectOne(queryWrapper);
        return ModelMapperUtil.map(entity, uClass, biConsumer);
    }

    /**
     * 查询并转换类型
     *
     * @param queryWrapper 查询条件
     * @param uClass       转换目标类型
     * @param <U>          目标类型
     * @return 转换后类型结果
     */
    default <U> List<U> selectList(Wrapper<TEntity> queryWrapper, Class<U> uClass) {
        List<TEntity> records = this.selectList(queryWrapper);
        return ModelMapperUtil.mapList(records, uClass);
    }

    /**
     * 查询并转换类型并且对转换结果处理
     *
     * @param queryWrapper 查询条件
     * @param uClass       转换目标类型
     * @param consumer     对转换结果处理函数
     * @param <U>          目标类型
     * @return 转换后类型结果
     */
    default <U> List<U> selectList(Wrapper<TEntity> queryWrapper, Class<U> uClass,
                                   Consumer<U> consumer) {
        List<TEntity> records = this.selectList(queryWrapper);
        return ModelMapperUtil.mapList(records, uClass, consumer);
    }

    /**
     * 查询并转换类型并且对转换结果处理
     *
     * @param queryWrapper 查询条件
     * @param uClass       转换目标类型
     * @param biConsumer   对转换结果处理函数
     * @param <U>          目标类型
     * @return 转换后类型结果
     */
    default <U> List<U> selectList(Wrapper<TEntity> queryWrapper, Class<U> uClass,
                                   BiConsumer<TEntity, U> biConsumer) {
        List<TEntity> records = this.selectList(queryWrapper);
        return ModelMapperUtil.mapList(records, uClass, biConsumer);
    }


    /**
     * 分页查询并转换查询结果
     *
     * @param pageIndex    页码
     * @param pageSize     页大小
     * @param queryWrapper 查询条件
     * @param uClass       将查询结果转换为指定DTO类型
     * @param <U>          指定的DTO类型
     * @return Page
     */
    default <U> Page<U> selectPage(long pageIndex, long pageSize, Wrapper<TEntity> queryWrapper,
                                   Class<U> uClass) {
        // 分页条件
        Page<TEntity> page = new Page<>(pageIndex, pageSize);
        // 执行分页查询
        Page<TEntity> pageResult = this.selectPage(page, queryWrapper);
        // 设置数据

        Page<U> uPage = new Page<>();
        uPage.setRecords(ModelMapperUtil.mapList(pageResult.getRecords(), uClass));
        this.setPageData(uPage, pageResult);
        return uPage;
    }

    private void setPageData(Page<?> uPage, Page<TEntity> pageResult) {
        uPage.setPages(pageResult.getPages());
        uPage.setSize(pageResult.getSize());
        uPage.setCurrent(pageResult.getCurrent());
        uPage.setTotal(pageResult.getTotal());
    }

    /**
     * 分页查询并转换查询结果
     *
     * @param page         分页条件
     * @param queryWrapper 查询条件
     * @param uClass       将查询结果转换为指定DTO类型
     * @param <U>          指定的DTO类型
     * @return Page
     */
    default <U> Page<U> selectPage(Page page, Wrapper<TEntity> queryWrapper,
                                   Class<U> uClass) {
        // 执行分页查询
        Page<TEntity> pageResult = this.selectPage(page, queryWrapper);

        Page<U> uPage = new Page<>();
        this.setPageData(uPage, pageResult);
        uPage.setRecords(ModelMapperUtil.mapList(pageResult.getRecords(), uClass));
        return uPage;
    }

    /**
     * 分页查询并转换查询结果，并对转换后数据处理
     *
     * @param pageIndex    页码
     * @param pageSize     页大小
     * @param queryWrapper 查询条件
     * @param uClass       将查询结果转换为指定DTO类型
     * @param consumer     对转换后的数据处理逻辑
     * @param <U>          指定的DTO类型
     * @return Page
     */
    default <U> Page<U> selectPage(long pageIndex, long pageSize, Wrapper<TEntity> queryWrapper,
                                   Class<U> uClass, Consumer<U> consumer) {

        // 分页条件
        Page<TEntity> page = new Page<>(pageIndex, pageSize);
        // 执行分页查询
        Page<TEntity> pageResult = this.selectPage(page, queryWrapper);

        // 转换类型并处理
        List<U> uResult = ModelMapperUtil.mapList(pageResult.getRecords(), uClass, consumer);

        Page<U> uPage = new Page<>();
        this.setPageData(uPage, pageResult);
        // 设置数据
        uPage.setRecords(uResult);
        return uPage;
    }

    /**
     * 分页查询并转换查询结果，并对转换后数据处理
     *
     * @param page         分页条件
     * @param queryWrapper 查询条件
     * @param uClass       将查询结果转换为指定DTO类型
     * @param consumer     对转换后的数据处理逻辑
     * @param <U>          指定的DTO类型
     * @return Page
     */
    default <U> Page<U> selectPage(Page page, Wrapper<TEntity> queryWrapper,
                                   Class<U> uClass, Consumer<U> consumer) {

        // 执行分页查询
        Page<TEntity> pageResult = this.selectPage(page, queryWrapper);
        // 转换类型并处理
        List<U> uResult = ModelMapperUtil.mapList(pageResult.getRecords(), uClass, consumer);

        Page<U> uPage = new Page<>();
        this.setPageData(uPage, pageResult);
        // 设置数据
        uPage.setRecords(uResult);
        return uPage;
    }


    /**
     * 分页查询并转换查询结果，并对元数据和转换后数据处理
     *
     * @param pageIndex    页码
     * @param pageSize     页大小
     * @param queryWrapper 查询条件
     * @param uClass       将查询结果转换为指定DTO类型
     * @param biconsumer   对原数据和转换后的数据处理逻辑
     * @param <U>          指定的DTO类型
     * @return Page
     */
    default <U> Page<U> selectPage(long pageIndex, long pageSize, Wrapper<TEntity> queryWrapper,
                                   Class<U> uClass, BiConsumer<TEntity, U> biconsumer) {

        // 分页条件
        Page<TEntity> page = new Page<>(pageIndex, pageSize);
        // 执行分页查询
        Page<TEntity> pageResult = this.selectPage(page, queryWrapper);
        // 转换类型并处理
        List<U> uResult = ModelMapperUtil.mapList(pageResult.getRecords(), uClass, biconsumer);

        Page<U> uPage = new Page<>();
        this.setPageData(uPage, pageResult);
        // 设置数据
        uPage.setRecords(uResult);
        return uPage;
    }

    /**
     * 分页查询并转换查询结果，并对元数据和转换后数据处理
     *
     * @param page         分页条件
     * @param queryWrapper 查询条件
     * @param uClass       将查询结果转换为指定DTO类型
     * @param biconsumer   对原数据和转换后的数据处理逻辑
     * @param <U>          指定的DTO类型
     * @return Page
     */
    default <U> Page<U> selectPage(Page page, Wrapper<TEntity> queryWrapper,
                                   Class<U> uClass, BiConsumer<TEntity, U> biconsumer) {

        // 执行分页查询
        Page<TEntity> pageResult = this.selectPage(page, queryWrapper);
        // 转换类型并处理
        List<U> uResult = ModelMapperUtil.mapList(pageResult.getRecords(), uClass, biconsumer);

        Page<U> uPage = new Page<>();
        this.setPageData(uPage, pageResult);
        // 设置数据
        uPage.setRecords(uResult);
        return uPage;
    }


    /**
     * 获取 SQL 语句 ID
     *
     * @param sqlMethod SQL 方法枚举
     * @return SQL 语句 ID
     */
    private String getSqlStatement(SqlMethod sqlMethod) {
        return SqlHelper.getSqlStatement(
                MybatisUtils.getMybatisMapperProxy(this).getMapperInterface(),
                sqlMethod
        );
    }

    /**
     * 执行批量操作
     *
     * @param list      数据集合
     * @param batchSize 批量大小
     * @param consumer  执行方法
     * @param <E>       泛型
     * @return 操作结果
     */
    private <E> boolean executeBatch(Collection<E> list, int batchSize, BiConsumer<SqlSession, E> consumer) {
        return SqlHelper.executeBatch(getSqlSessionFactory(), LogFactory.getLog(getClass()), list, batchSize, consumer);
    }

    /**
     * 执行批量操作（默认批次大小）
     *
     * @param list     数据集合
     * @param consumer 执行方法
     * @param <E>      泛型
     * @return 操作结果
     */
    private <E> boolean executeBatch(Collection<E> list, BiConsumer<SqlSession, E> consumer) {
        return executeBatch(list, 1000, consumer);
    }

    /**
     * 批量插入
     *
     * @param entityList 实体列表
     * @return 操作结果
     */
    default boolean insertBatch(Collection<TEntity> entityList) {
        return insertBatch(entityList, 1000);
    }

    /**
     * 批量插入
     *
     * @param entityList 实体列表
     * @param batchSize  批量大小
     * @return 操作结果
     */
    default boolean insertBatch(Collection<TEntity> entityList, int batchSize) {
        String sqlStatement = getSqlStatement(SqlMethod.INSERT_ONE);
        return executeBatch(entityList, batchSize, (sqlSession, entity) -> sqlSession.insert(sqlStatement, entity));
    }

    /**
     * 批量更新
     *
     * @param entityList 实体列表
     * @return 操作结果
     */
    default boolean updateBatchById(Collection<TEntity> entityList) {
        return updateBatchById(entityList, 1000);
    }

    /**
     * 批量更新
     *
     * @param entityList 实体列表
     * @param batchSize  批量大小
     * @return 操作结果
     */
    default boolean updateBatchById(Collection<TEntity> entityList, int batchSize) {
        String sqlStatement = getSqlStatement(SqlMethod.UPDATE_BY_ID);
        return executeBatch(entityList, batchSize, (sqlSession, entity) -> {
            MapperMethod.ParamMap<TEntity> param = new MapperMethod.ParamMap<>();
            param.put(Constants.ENTITY, entity);
            sqlSession.update(sqlStatement, param);
        });
    }

    /**
     * 获取批量操作 SqlSession
     *
     * @return SqlSession
     */
    default SqlSession sqlSessionBatch() {
        return getSqlSessionFactory().openSession(ExecutorType.BATCH);
    }

    /**
     * 获取 SqlSessionFactory
     *
     * @return SqlSessionFactory
     */
    private SqlSessionFactory getSqlSessionFactory() {
        MybatisMapperProxy<?> mybatisMapperProxy = MybatisUtils.getMybatisMapperProxy(this);
        return MybatisUtils.getSqlSessionFactory(mybatisMapperProxy);
    }

}
