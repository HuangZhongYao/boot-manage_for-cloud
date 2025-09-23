package org.github.bm.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseVO;

import java.time.LocalDateTime;

/**
 * Time 2025-09-23 16:10
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EncryptionPublicKeyVO extends BaseVO {

    @Schema(description = "加密算法")
    private String algorithm;

    @Schema(description = "加密公钥")
    private String publicKey;

    @Schema(description = "会话Id")
    private String sessionId;

    @Schema(description = "过期时间")
    private LocalDateTime expirationTime;
}
