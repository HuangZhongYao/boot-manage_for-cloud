package org.github.bm.common.constant;

import org.github.bm.common.enums.ClientEnum;

public interface RedisConstant {


    interface Authorization {
        /**
         * 授权缓存key前缀
         */
        String BASE_KEY_PREFIX = "Authorization:";
        /**
         * 授权信息缓存key
         */
        String AUTHORIZATION_INFO = BASE_KEY_PREFIX + "info";
        /**
         * 刷新令牌缓存key
         */
        String REFRESH_TOKEN = BASE_KEY_PREFIX + "RefreshToken:";
        /**
         * 刷新令牌缓存时间，单位秒
         */
        long REFRESH_TOKEN_CACHE_TIME = 3 * 24 * 60 * 60;
        /**
         * web端授权令牌缓存key
         */
        String WEB_AUTHORIZATION_KEY = BASE_KEY_PREFIX + ClientEnum.WEB.code + ":";
        /**
         * pc端授权令牌缓存key
         */
        String PC_AUTHORIZATION_KEY = BASE_KEY_PREFIX + ClientEnum.PC.code + ":";
        /**
         * 移动端授权令牌缓存key
         */
        String MOBILE_AUTHORIZATION_KEY = BASE_KEY_PREFIX + ClientEnum.MOBILE.code + ":";
    }


}
