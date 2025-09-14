package org.github.bm.websocket.base;

public interface SimpConstant {
    String TOPIC_PREFIX = "/topic";
    String QUEUE_PREFIX = "/queue";
    String APP_DESTINATION_PREFIX = "/app";
    String USER_DESTINATION_PREFIX = "/user";
    String SIMP_USER_KEY = "userId";
    String SIMP_AUTHENTICATED_KEY = "authenticated";
    String SIMP_SESSION_ID_KEY = "simpSessionId";

    interface Topic {
        String TEST_TOPIC = TOPIC_PREFIX + "/testNotificationsMessages";
        String NOTIFICATIONS_TOPIC = TOPIC_PREFIX + "/notificationsMessages";
    }

    interface Queue {
        String USER_QUEUE_MESSAGES = QUEUE_PREFIX + "/messages";
    }
}
