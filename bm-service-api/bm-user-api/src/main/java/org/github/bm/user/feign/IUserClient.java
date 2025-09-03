package org.github.bm.user.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

/**
 * 用户服务暴露接口，最好不要UserController实现它来复用已有接口
 */
@FeignClient(value = AppConstant.APPLICATION_USER_NAME, contextId = "userClient", fallback = UserClientFallback.class)
public interface IUserClient extends BaseFeign {

    String API_PREFIX = BASE_API_PREFIX + "/user";
    String GET_USER_BY_ID = API_PREFIX + "/getUserByID";
    String GET_USER_BY_ID_List = API_PREFIX + "/getUserByIDList";
    String GET_USER_BY_ACCOUNT = API_PREFIX + "/getUserByAccount";
    String GET_ALL_USER_ID_LIST = API_PREFIX + "/getAllUserIdList";
    String GET_ORGANIZATION_USER_LIST_BY_ORGANIZATION_ID_LIST = API_PREFIX + "/getOrganizationUserListByOrganizationIdList";
    String GET_ORGANIZATION_USER_ID_LIST_BY_ORGANIZATION_ID_LIST = API_PREFIX + "/getOrganizationUserIdListByOrganizationIdList";

    /**
     * 根据ID查询用户
     *
     * @param id 用户 ID
     * @return 用户实体
     */
    @PostMapping(GET_USER_BY_ID)
    UserEntity getUserByID(@RequestParam("id") Serializable id);

    /**
     * 根据ID列表查询用户
     *
     * @param ids ID列表
     * @return 用户实体列表
     */
    @PostMapping(GET_USER_BY_ID_List)
    List<UserEntity> getUserByIDList(@RequestParam("ids") List<Long> ids);

    /**
     * 根据账号查询用户
     *
     * @param account 账号
     * @return 用户实体
     */
    @GetMapping(GET_USER_BY_ACCOUNT)
    UserEntity getUserByAccount(@RequestParam("account") String account);

    /**
     * 获取所有用户ID列表
     *
     * @return 用户ID列表
     */
    @GetMapping(GET_ALL_USER_ID_LIST)
    List<Long> getAllUserIdList();

    /**
     * 根据组织ID列表查询组织用户
     *
     * @param ids 组织ID列表
     * @return 组织用户列表
     */
    @GetMapping(GET_ORGANIZATION_USER_LIST_BY_ORGANIZATION_ID_LIST)
    List<UserEntity> getOrganizationUserListByOrganizationIdList(@RequestParam("ids") List<Long> ids);

    /**
     * 根据组织ID列表查询组织用户ID列表
     *
     * @param ids 组织ID列表
     * @return 组织用户ID列表
     */
    @GetMapping(GET_ORGANIZATION_USER_ID_LIST_BY_ORGANIZATION_ID_LIST)
    List<Long> getOrganizationUserIdListByOrganizationIdList(@RequestParam("ids") List<Long> ids);
}
