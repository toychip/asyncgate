package com.asyncgate.signaling_server.support.handler;

import com.asyncgate.signaling_server.signaling.KurentoManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.kurento.client.MediaPipeline;
import org.kurento.client.WebRtcEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
@RequiredArgsConstructor
public class KurentoHandler extends TextWebSocketHandler {
    private final Map<String, WebRtcEndpoint> endpoints = new ConcurrentHashMap<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("handler start");

        JsonObject jsonMessage = JsonParser.parseString(message.getPayload()).getAsJsonObject();
        String roomId = jsonMessage.get("roomId").getAsString();
        String userId = jsonMessage.get("userId").getAsString();
        String sdpOffer = jsonMessage.get("sdpOffer").getAsString();

        // ✅ WebSocket을 통해 KurentoManager에게 MediaPipeline 요청을 보냄
        JsonObject response = new JsonObject();
        response.addProperty("id", "requestPipeline");
        response.addProperty("roomId", roomId);
        response.addProperty("userId", userId);
        response.addProperty("sdpOffer", sdpOffer);

        session.sendMessage(new TextMessage(response.toString()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        WebRtcEndpoint endpoint = endpoints.remove(session.getId());
        if (endpoint != null) {
            endpoint.release();
        }
    }
}