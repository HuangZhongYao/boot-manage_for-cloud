package org.github.bm.user.web;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.DependentRequired;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.common.security.AuthUser;
import org.github.bm.common.security.SecurityContextHolder;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.enums.GenderEnum;
import org.github.bm.user.feign.IUserClient;
import org.github.bm.user.repositery.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Tag(name = "用户接口")
@RestController
@RequestMapping(IUserClient.API_PREFIX)
@DependentRequired
@AllArgsConstructor
public class UserController extends BaseController {

    SnowflakeGenerator snowflakeGenerator;
    UserRepository userRepository;

    @Operation(summary = "根据Id获取用户")
    @GetMapping("/getById")
    public Object getByid() {
        ArrayList<Long> longs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            longs.add(snowflakeGenerator.next());
        }
        List<UserEntity> userEntities = userRepository.selectList(new QueryWrapper<UserEntity>().eq("1", "1"));
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("adf", longs);
        stringObjectHashMap.put("adfsdfsd", userEntities);
        return stringObjectHashMap;
    }

    @Operation(summary = "根据Id获取用户")
    @PostMapping("/save")
    public ApiResponse<Boolean> save() {
        UserEntity userEntity = UserEntity.builder().account("xxxxxxx45454").phone("17685306043").password("dfsdfsdfsdfsd").enable(Boolean.TRUE).avatarUrl("34234").gender(GenderEnum.MALE).username("7878").build();
        int insert = userRepository.insert(userEntity);
        AuthUser authUser = SecurityContextHolder.getAuthUser();
        return ApiResponse.ok(insert > 0);
    }
}
