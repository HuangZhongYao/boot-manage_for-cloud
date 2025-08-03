package org.github.bm.user.feign;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.repositery.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务feign客户端实现
 */
@RestController
public class UserClient implements IUserClient {
    @Resource
    private UserRepository userRepository;

    @Override
    @GetMapping(GET_USER_BY_ID)
    public UserEntity getUserByID(@RequestParam("id") Long id) {
        return userRepository.selectById(id);
    }

    @Override
    @GetMapping(GET_USER_BY_ACCOUNT)
    public UserEntity getUserByAccount(@RequestParam("account") String account) {
        return userRepository.selectOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getAccount, account).last(" limit 1 "));
    }
}
