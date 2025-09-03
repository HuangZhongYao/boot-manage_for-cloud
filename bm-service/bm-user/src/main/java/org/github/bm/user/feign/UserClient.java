package org.github.bm.user.feign;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * 用户服务feign客户端实现
 */
@Hidden
@RestController
public class UserClient implements IUserClient {
    @Resource
    private UserRepository userRepository;

    @Override
    @PostMapping(GET_USER_BY_ID)
    public UserEntity getUserByID(@RequestParam("id") Serializable id) {
        return userRepository.selectById(id);
    }

    @Override
    @PostMapping(GET_USER_BY_ID_List)
    public List<UserEntity> getUserByIDList(List<Long> ids) {
        return userRepository.selectBatchIds(ids);
    }

    @Override
    @GetMapping(GET_USER_BY_ACCOUNT)
    public UserEntity getUserByAccount(@RequestParam("account") String account) {
        return userRepository.selectOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getAccount, account).last(" limit 1 "));
    }

    @Override
    @GetMapping(GET_ALL_USER_ID_LIST)
    public List<Long> getAllUserIdList() {
        return userRepository.selectList(new LambdaQueryWrapper<UserEntity>().select(UserEntity::getId)).stream().map(UserEntity::getId).toList();
    }
}
