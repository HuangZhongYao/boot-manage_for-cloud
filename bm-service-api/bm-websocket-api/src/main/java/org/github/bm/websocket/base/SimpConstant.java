package org.github.bm.websocket.base;

/**
 * WebSocket通信中使用的常量定义接口
 * 定义了消息目的地前缀、用户会话相关键值等常量
 */
public interface SimpConstant {
    /**
     * 公告主题消息前缀
     */
    String TOPIC_PREFIX = "/topic";
    /**
     * 队列消息前缀
     */
    String QUEUE_PREFIX = "/queue";
    /**
     * 应用程序目的地前缀
     */
    String APP_DESTINATION_PREFIX = "/app";
    /**
     * 用户目的地前缀
     */
    String USER_DESTINATION_PREFIX = "/user";
    /**
     * 用户ID键值
     */
    String SIMP_USER_KEY = "userId";
    /**
     * 认证状态键值
     */
    String SIMP_AUTHENTICATED_KEY = "authenticated";
    /**
     * 会话ID键值
     */
    String SIMP_SESSION_ID_KEY = "simpSessionId";

    /**
     * 主题消息相关常量定义
     */
    interface Topic {
        /**
         * 测试通知消息主题
         */
        String TEST_TOPIC = TOPIC_PREFIX + "/testNotificationsMessages";
        /**
         * 公告通知消息主题
         */
        String NOTIFICATIONS_TOPIC = TOPIC_PREFIX + "/notificationsMessages";
    }

    /**
     * 队列消息相关常量定义
     */
    interface Queue {

        /**
         * 用户队列消息路径
         */
        String USER_QUEUE_MESSAGES = QUEUE_PREFIX + "/messages";

        /**
         * 用户队列消息路径 , 手动转换用户
         */
        String USER_QUEUE_MESSAGES_BY_USER_ID = USER_DESTINATION_PREFIX + "{userId}" + QUEUE_PREFIX + "/messages";
    }
}

