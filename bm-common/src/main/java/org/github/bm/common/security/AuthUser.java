package org.github.bm.common.security;

import lombok.Getter;
import org.github.bm.common.base.entity.AbstractIdEntity;

import java.io.Serial;

@Getter
public class AuthUser extends AbstractIdEntity {
    @Serial
    private static final long serialVersionUID = -4075127738715995785L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账号
     */
    private String account;

    /**
     * 手机号
     */
    private String phone;


    /**
     * 启用状态
     */
    private Boolean enable;

    public AuthUser() {
    }

    public AuthUser(String username, String account, String phone, Boolean enable) {
        this.username = username;
        this.account = account;
        this.phone = phone;
        this.enable = enable;
    }
}
