package org.github.bm.common.constant;

import org.github.bm.common.enums.ClientEnum;

public interface RedisConstant {

    /**
     * 授权信息
     */
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
        long ACCESS_TOKEN_CACHE_TIME = 60;

        /**
         * 刷新令牌缓存时间，单位秒
         */
        long REFRESH_TOKEN_CACHE_TIME = 3 * 24 * 60 * 60;
        /**
         * 授权信息缓存时间，单位秒
         */
        long AUTHORIZATION_INFO_CACHE_TIME = 7 * 24 * 60 * 60;

        /**
         * 获取客户端访问令牌缓存key前缀
         *
         * @param clientEnum 客户端枚举
         * @return 客户端访问令牌缓存key前缀
         */
        static String clientAuthorizationCacheKey(ClientEnum clientEnum) {
            return ACCESS_TOKEN + clientEnum.code + ":";
        }

        /**
         * 获取客户端刷新令牌缓存key前缀
         *
         * @param clientEnum 客户端枚举
         * @return 获取客户端刷新令牌缓存key前缀
         */
        static String clientRefreshTokenCacheKey(ClientEnum clientEnum) {
            return REFRESH_TOKEN + clientEnum.code + ":";
        }
    }

    /**
     * 在线用户
     */
    interface OnlineUser {
        /**
         * 在线用户缓存 key前缀
         */
        String BASE_KEY_PREFIX = "OnlineUser:";
        /**
         * 在线用户ID集合 key
         */
        String ONLINE_USER_ID_SET_KEY = BASE_KEY_PREFIX + "IdSet";
    }


    /**
     * 加密相关
     */
    interface Encryption {
        /**
         * 加密私钥缓存时长
         */
        int ENCRYPTION_SESSION_EXPIRATION_TIME = 60 * 30;
        /**
         * 加密私钥缓存key前缀
         */
        String ENCRYPTION_KEY_PREFIX = "Encryption:PrivateKey:";
    }
}
