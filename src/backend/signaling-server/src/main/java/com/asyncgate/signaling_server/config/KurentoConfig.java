package com.asyncgate.signaling_server.config;

import com.asyncgate.signaling_server.signaling.KurentoManager;
import com.asyncgate.signaling_server.support.handler.KurentoHandler;
import lombok.RequiredArgsConstructor;
import org.kurento.client.KurentoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import java.util.Objects;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class KurentoConfig implements WebSocketConfigurer {

    @Value("${kms.url}")
    private String kmsUrl;

    private final KurentoHandler kurentoHandler; // ✅ KurentoHandler는 WebSocket 핸들러만 담당

    @Bean
    public KurentoClient kurentoClient() {
        if (kmsUrl == null || kmsUrl.isEmpty()) {
            throw new IllegalStateException("KMS URL이 설정되지 않았습니다. application.properties 확인하세요.");
        }
        System.out.println("KurentoClient 생성 시도 중: " + kmsUrl);
        return KurentoClient.create(kmsUrl);
    }

    @Bean
    public KurentoManager kurentoManager(KurentoClient kurentoClient) {
        return new KurentoManager(kurentoClient);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(kurentoHandler, "/signal").setAllowedOrigins("*");
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(32768);
        container.setMaxBinaryMessageBufferSize(32768);
        return container;
    }
}