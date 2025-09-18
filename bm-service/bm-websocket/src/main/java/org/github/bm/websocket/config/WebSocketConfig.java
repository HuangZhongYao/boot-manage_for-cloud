package org.github.bm.websocket.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.websocket.base.SimpConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.util.Map;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Resource
    private AuthHandshakeInterceptor authHandshakeInterceptor;
    @Resource
    private AuthHandshakeHandler authHandshakeHandler;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册STOMP端点
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .addInterceptors(authHandshakeInterceptor)// 添加握手拦截器
                .setHandshakeHandler(authHandshakeHandler)// 添加握手处理器
                .withSockJS(); // 支持SockJS回退
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 配置消息代理            ！！注意如果websocket需要部署多个服务则不能使用简单代理了。需要依赖外部消息代理如RabbitMQ
        registry.enableSimpleBroker(SimpConstant.TOPIC_PREFIX, SimpConstant.QUEUE_PREFIX, SimpConstant.USER_DESTINATION_PREFIX); // 启用简单代理
        registry.setApplicationDestinationPrefixes(SimpConstant.APP_DESTINATION_PREFIX); // 应用程序目的地前缀
        registry.setUserDestinationPrefix(SimpConstant.USER_DESTINATION_PREFIX); // 用户目的地前缀
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            /**
             * 在消息发送到通道之前执行的回调方法
             * 这是消息处理链中的第一个环节，可以用来修改消息或执行前置处理
             *
             * @param message 要发送的消息对象
             * @param channel 消息将要发送到的通道
             * @return 处理后的消息对象，如果返回null则取消消息发送
             */
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                // 使用StompHeaderAccessor包装消息，便于访问STOMP协议相关头信息
                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

                // 检查是否为CONNECT命令（WebSocket连接建立时的握手消息）
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                    // 获取WebSocket会话属性
                    // 会话属性是在握手阶段由HandshakeInterceptor设置的
                    // 包含了用户认证信息等上下文数据
                    Map<String, Object> sessionAttributes = accessor.getSessionAttributes();

                    // 验证会话属性是否存在且包含用户标识键
                    // SimpConstant.SIMP_USER_KEY是自定义的常量，用于标识会话中的用户信息键
                    if (sessionAttributes != null && sessionAttributes.containsKey(SimpConstant.SIMP_USER_KEY)) {
                        // 从会话属性中获取用户ID
                        // 在握手拦截器(AuthHandshakeInterceptor)中，已经将解析出的用户ID
                        // 存储在会话属性的SimpConstant.SIMP_USER_KEY键下
                        Object userId = accessor.getSessionAttributes().get(SimpConstant.SIMP_USER_KEY);

                        // 将用户ID设置到STOMP访问器中，使其成为Principal
                        // 这样在后续的消息处理方法中可以通过Principal参数获取当前用户信息
                        // 这样设置后，Controller中的Principal.getName()将返回用户ID字符串
                        log.info("从会话属性中获取到用户ID: {}", userId);
                        // 设置Principal
                        accessor.setUser(StompPrincipal.builder().name(userId.toString()).build());
                        log.info("Principal已设置，用户ID: {}", userId);
                    } else {
                        log.warn("会话属性中未找到用户信息，会话属性: {}", sessionAttributes);
                    }
                }

                // 返回原始消息或修改后的消息
                // 如果需要阻止消息处理，可以返回null
                return message;
            }
        });
    }
}