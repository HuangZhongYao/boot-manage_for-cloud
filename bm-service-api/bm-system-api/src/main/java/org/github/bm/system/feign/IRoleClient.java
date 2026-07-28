package org.github.bm.system.feign;

import org.github.bm.base.base.fegin.BaseFeign;
import org.github.bm.base.constant.AppConstant;
import org.github.bm.system.entity.RoleEntity;
import org.github.bm.system.entity.UserRoleEntity;
import org.github.bm.system.feign.fallback.RoleClientFallback;
import org.github.bm.system.vo.RoleVO;
import org.github.bm.system.vo.UserRoleVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

@FeignClient(value = AppConstant.APPLICATION_SYSTEM_NAME, contextId = "roleClient", fallback = RoleClientFallback.class)
public interface IRoleClient extends BaseFeign {

    String API_PREFIX = BASE_API_PREFIX + "/role";
    String GET_ROLE_BY_ID = API_PREFIX + "/getRoleById";
    String GET_ROLE_BY_ID_LIST = API_PREFIX + "/getRoleByIdList";
    String GET_ROLE_BY_USER_ID = API_PREFIX + "/getRoleByUserId";
    String GET_ROLE_VO_BY_USER_ID = API_PREFIX + "/getRoleVoByUserId";
    String GET_ROLE_BY_USER_ID_LIST = API_PREFIX + "/getRoleByUserIdList";
    String GET_USER_ROLE_BY_USER_ID_LIST = API_PREFIX + "/getUserRoleByUserIdList";
    String GET_USER_ROLE_VO_BY_USER_ID_LIST = API_PREFIX + "/getUserRoleVoByUserIdList";
    String DEL_USER_ROLE_BY_USER_ID = API_PREFIX + "/delUserRoleByUserId";
    String DEL_USER_ROLE_BY_USER_ID_LIST = API_PREFIX + "/delUserRoleByUserIdList";
    String ADD_USER_ROLE_BY_USER_ID = API_PREFIX + "/addUserRoleByUserId";

    /**
     * 根据id查询角色
     *
     * @param id 角色id
     * @return 角色
     */
    @PostMapping(GET_ROLE_BY_ID)
    RoleEntity getRoleById(@RequestParam("id") Serializable id);

    /**
     * 根据id列表查询角色
     *
     * @param ids id列表
     * @return 角色列表
     */
    @PostMapping(GET_ROLE_BY_ID_LIST)
    List<RoleEntity> getRoleByIdList(@RequestParam("ids") List<Long> ids);

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @PostMapping(GET_ROLE_BY_USER_ID)
    List<RoleEntity> getRoleByUserId(@RequestParam("userId") Serializable userId);

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @PostMapping(GET_ROLE_VO_BY_USER_ID)
    List<RoleVO> getRoleVoByUserId(@RequestParam("userId") Serializable userId);

    /**
     * 根据用户id列表查询角色
     *
     * @param userIds 用户id列表
     * @return 角色列表
     */
    @PostMapping(GET_ROLE_BY_USER_ID_LIST)
    List<RoleEntity> getRoleByUserIdList(@RequestParam("userIds") List<Long> userIds);

    /**
     * 根据用户id列表查询用户关联角色
     *
     * @param userIds 用户id
     * @return 用户关联角色列表
     */
    @PostMapping(GET_USER_ROLE_BY_USER_ID_LIST)
    List<UserRoleEntity> getUserRoleByUserIdList(@RequestParam("userIds") List<Long> userIds);

    /**
     * 根据用户id列表查询用户关联角色
     *
     * @param userIds 用户id列表
     * @return 用户关联角色列表
     */
    @PostMapping(GET_USER_ROLE_VO_BY_USER_ID_LIST)
    List<UserRoleVO> getUserRoleVoByUserIdList(@RequestParam("userIds") List<Long> userIds);

    /**
     * 根据用户id删除用户关联角色
     *
     * @param userId 用户id
     * @return 删除数量
     */
    @PostMapping(DEL_USER_ROLE_BY_USER_ID)
    Integer delUserRoleByUserId(@RequestParam("userId") Serializable userId);

    /**
     * 根据用户id列表删除用户关联角色
     *
     * @param userIds 用户id列表
     * @return 删除数量
     */
    @PostMapping(DEL_USER_ROLE_BY_USER_ID_LIST)
    Integer delUserRoleByUserIds(@RequestParam("userIds") List<Long> userIds);


    /**
     * 给用户添加关联角色
     *
     * @param userRoleEntityList 用户角色关联实体列表
     * @return 是否成功
     */
    @PostMapping(ADD_USER_ROLE_BY_USER_ID)
    Boolean addUserRoleByUserId(@RequestBody List<UserRoleEntity> userRoleEntityList);

}
