package org.github.bm.common.constant;

public interface RedisConstant {


    public interface AuthUser {
        String BASE_KEY_PREFIX = "auth:user:";
        String USER_ID = "userId";
        String USER_NAME = "userName";
        String USER_ACCOUNT = "userAccount";
        String USER_PHONE = "userPhone";
        String USER_ENABLE = "userEnable";
    }
}
