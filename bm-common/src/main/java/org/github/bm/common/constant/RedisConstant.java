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
        String AUTHORIZATION_INFO = BASE_KEY_PREFIX + "info:";
        /**
         * 刷新令牌缓存key
         */
        String REFRESH_TOKEN = BASE_KEY_PREFIX + "RefreshToken:";
        /**
         * 访问令牌缓存key
         */
        String ACCESS_TOKEN = BASE_KEY_PREFIX + "AccessToken:";

        /**
         * 访问令牌缓存时间，单位秒
         */
//        long ACCESS_TOKEN_CACHE_TIME = 3 * 60 * 60;
        long ACCESS_TOKEN_CACHE_TIME =  60;

        /**
         * 刷新令牌缓存时间，单位秒
         */
        long REFRESH_TOKEN_CACHE_TIME = 3 * 24 * 60 * 60;
        /**
         * 授权信息缓存时间，单位秒
         */
        long AUTHORIZATION_INFO_CACHE_TIME = 7 * 24 * 60 * 60;

        static  String clientAuthorizationCacheKey(ClientEnum clientEnum) {
            return ACCESS_TOKEN + clientEnum.code + ":";
        }

        static  String clientRefreshTokenCacheKey(ClientEnum clientEnum) {
            return REFRESH_TOKEN + clientEnum.code + ":";
        }
    }


}
