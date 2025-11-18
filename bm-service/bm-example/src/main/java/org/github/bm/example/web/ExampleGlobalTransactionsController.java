package org.github.bm.example.web;

import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.IUserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示使用seata分布式事务
 * Time 2025-11-18 16:14
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "演示Sentinel限流")
@RestController
@RequestMapping("/test/transactions/")
@RequiredArgsConstructor
public class ExampleGlobalTransactionsController {
    private final IUserClient userClient;
    @GetMapping
    @GlobalTransactional
    public String exampleGlobalTransactions() throws InterruptedException {
        UserEntity userEntity = userClient.getUserByID(Long.valueOf("1"));
        System.out.println("userEntity = " + userEntity);
        Thread.sleep(15000);
        return "ok";
    }
}
