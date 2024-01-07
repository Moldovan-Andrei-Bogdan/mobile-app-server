package com.mecorp.backend.config;

import com.mecorp.backend.socket.WebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final Map<String, WebSocketSession> websocketSessions = new HashMap<>();

    @Bean("websocketSessions")
    public Map<String, WebSocketSession> getWebsocketSessions() {
        return websocketSessions;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandler(websocketSessions), "/websocket/notifications");
    }
}
