package org.github.bm.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.dto.AddOrganizationInputDTO;
import org.github.bm.system.dto.EditOrganizationInputDTO;
import org.github.bm.system.dto.OrganizationPageQueryInputDTO;
import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.vo.OrganizationTreeVO;
import org.github.bm.system.vo.OrganizationVO;
import org.github.bm.user.entity.UserEntity;

/**
 * 组织机构服务接口
 * 定义了组织机构相关的业务操作接口
 */
public interface IOrganizationService {
    /**
     * 获取组织机构树形结构
     * 查询所有组织机构并构建成树形结构返回
     *
     * @return 组织机构树形结构列表
     */
    List<OrganizationTreeVO> organizationTree();

    /**
     * 分页查询组织机构列表
     * 根据查询条件进行分页查询组织机构信息
     *
     * @param inputDTO 组织机构分页查询条件DTO
     * @return 分页查询结果，包含组织机构VO列表
     */
    Page<OrganizationVO> pageQueryList(OrganizationPageQueryInputDTO inputDTO);

    /**
     * 添加组织机构
     * 新增一个组织机构信息
     *
     * @param inputDTO 添加组织机构的输入参数DTO
     * @return 添加结果，true表示成功，false表示失败
     */
    Boolean addOrganization(AddOrganizationInputDTO inputDTO);

    /**
     * 编辑组织机构
     * 修改组织机构信息
     *
     * @param inputDTO 编辑组织机构的输入参数DTO
     * @return 编辑结果，true表示成功，false表示失败
     */
    Boolean editOrganization(EditOrganizationInputDTO inputDTO);

    /**
     * 删除组织机构
     * 根据ID删除组织机构信息
     *
     * @param inputDTO 包含要删除的组织机构ID列表的输入参数DTO
     * @return 删除结果，true表示成功，false表示失败
     */
    Boolean delOrganization(BaseManyLongIdInputDTO inputDTO);

    /**
     * 查询组织机构及其子组织机构
     * 根据指定ID查询该组织机构及其所有子组织机构
     *
     * @param id 组织机构ID
     * @return 组织机构实体列表，包含指定组织机构及其所有子组织机构
     */
    List<OrganizationEntity> queryOrganizationAndSubOrganization(Long id);

    /**
     * 根据组织id列表查询组织
     *
     * @param ids 组织id列表
     * @return 组织列表
     */
    List<OrganizationEntity> queryOrganizationByIds(List<Long> ids);

    /**
     * 根据组织id列表查询组织用户
     *
     * @param ids 组织id列表
     * @return 组织用户列表
     */
    List<UserEntity> queryOrganizationUserEntityListByIds(List<Long> ids);

    /**
     * 根据组织id列表查询组织用户id列表
     *
     * @param ids 组织id列表
     * @return 组织用户id列表
     */
    List<Long> queryOrganizationUserIdListByIds(List<Long> ids);
}

