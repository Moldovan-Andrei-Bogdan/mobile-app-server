package com.mecorp.backend.socket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BroadcastUtil {
    private final Map<String, WebSocketSession> websocketSessions;

    public void sendDataChangeMessage() {
        TextMessage textMessage = new TextMessage("new-data-arrived");
        websocketSessions.forEach((id, websocketSession) -> {
            try {
                websocketSession.sendMessage(textMessage);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
