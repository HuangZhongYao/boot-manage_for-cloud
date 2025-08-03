package org.github.bm.user.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.user.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务暴露接口，最好不要UserController实现它来复用已有接口
 */
@FeignClient(value = AppConstant.APPLICATION_USER_NAME)
public interface IUserClient extends BaseFeign {

    String API_PREFIX = BASE_API_PREFIX + "/user";
    String GET_USER_BY_ID = API_PREFIX + "/getUserByID";
    String GET_USER_BY_ACCOUNT = API_PREFIX + "/getUserByAccount";

    @GetMapping(GET_USER_BY_ID)
    UserEntity getUserByID(@RequestParam("id") Long id);

    @GetMapping(GET_USER_BY_ACCOUNT)
    UserEntity getUserByAccount(@RequestParam("account") String account);
}
