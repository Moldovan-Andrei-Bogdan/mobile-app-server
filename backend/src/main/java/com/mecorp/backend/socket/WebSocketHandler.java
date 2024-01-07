package com.mecorp.backend.socket;

import lombok.RequiredArgsConstructor;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;

@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> websocketSessions;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        var sessionId = session.getId();
        websocketSessions.put(sessionId, session);

        TextMessage handshake = new TextMessage("Established connection");
        session.sendMessage(handshake);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        var sessionId = session.getId();
        websocketSessions.remove(sessionId);
    }
}
