package org.github.bm.auth.web;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.RSA;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.github.bm.auth.vo.EncryptionPublicKeyVO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.common.constant.RedisConstant;
import org.github.bm.core.service.IRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Time 2025-09-23 16:01
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "加密接口")
@RestController
@RequestMapping("/encryption")
@AllArgsConstructor
public class EncryptionController extends BaseController {

    @Resource
    private IRedisService redisService;

    @Operation(summary = "获取公钥")
    @GetMapping("/getEncryptionPublicKey")
    public ApiResponse<EncryptionPublicKeyVO> getEncryptionPublicKey() {
        // 生成RSA密钥对
        RSA rsa = new RSA(AsymmetricAlgorithm.RSA.getValue());
        // 获取公钥和私钥
        String publicKey = rsa.getPublicKeyBase64();
        String privateKey = rsa.getPrivateKeyBase64();
        // 生成会话Id
        String sessionId = IdUtil.nanoId(25);
        // 存储私钥到Redis
        redisService.set(RedisConstant.Encryption.ENCRYPTION_KEY_PREFIX + sessionId, privateKey, RedisConstant.Encryption.ENCRYPTION_SESSION_EXPIRATION_TIME);
        // 封装返回数据
        return ok(EncryptionPublicKeyVO
                .builder()
                .algorithm(AsymmetricAlgorithm.RSA.getValue())
                .publicKey(publicKey)
                .sessionId(sessionId)
                .expirationTime(LocalDateTime.now().plusSeconds(RedisConstant.Encryption.ENCRYPTION_SESSION_EXPIRATION_TIME))
                .build());
    }
}
