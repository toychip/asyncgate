package com.asyncgate.signaling_server.support.handler;

import com.asyncgate.signaling_server.signaling.KurentoManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kurento.client.IceCandidate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Slf4j
@Component
public class KurentoHandler extends TextWebSocketHandler {

    private final KurentoManager kurentoManager;
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public KurentoHandler(KurentoManager kurentoManager) {
        this.kurentoManager = kurentoManager;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.put(session.getId(), session);
        log.info("WebSocket 연결됨: {}", session.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        JsonObject jsonMessage = new Gson().fromJson(message.getPayload(), JsonObject.class);
        log.info("WebSocket 메시지 수신: {}", jsonMessage);

        if (!jsonMessage.has("id")) {
            log.error("WebSocket 메시지 오류: id 필드 없음");
            return;
        }

        String messageType = jsonMessage.get("id").getAsString();
        String roomId = jsonMessage.has("roomId") ? jsonMessage.get("roomId").getAsString() : null;
        String userId = jsonMessage.has("userId") ? jsonMessage.get("userId").getAsString() : null;

        if (roomId == null || userId == null) {
            log.error("WebSocket 메시지 오류: roomId 또는 userId가 null");
            return;
        }

        switch (messageType) {
            case "join":
                handleJoin(roomId, userId);
                break;
            case "start":
                handleStart(session, roomId, userId, jsonMessage);
                break;
            case "candidate":
                handleIceCandidate(roomId, userId, jsonMessage);
                break;
            case "toggleAudio":
                toggleMediaState(roomId, userId, "audio", jsonMessage.get("enabled").getAsBoolean());
                break;
            case "toggleVideo":
                toggleMediaState(roomId, userId, "video", jsonMessage.get("enabled").getAsBoolean());
                break;
            case "toggleScreen":
                toggleMediaState(roomId, userId, "screen", jsonMessage.get("enabled").getAsBoolean());
                break;
            case "leave":
                handleLeave(roomId, userId, session);
                break;
            default:
                log.warn("알 수 없는 WebSocket 메시지 유형: {}", messageType);
        }
    }

    private void handleJoin(String roomId, String userId) {
        log.info("사용자 참여: {} (방: {})", userId, roomId);
        kurentoManager.addUserToRoom(roomId, userId);
    }

    private void handleStart(WebSocketSession session, String roomId, String userId, JsonObject jsonMessage) throws IOException {
        if (!jsonMessage.has("sdpOffer")) {
            log.error("handleStart 오류: sdpOffer 필드 없음");
            return;
        }

        String sdpOffer = jsonMessage.get("sdpOffer").getAsString();
        kurentoManager.processSdpOffer(roomId, userId, sdpOffer, sdpAnswer -> {
            try {
                JsonObject response = new JsonObject();
                response.addProperty("id", "response");
                response.addProperty("userId", userId);
                response.addProperty("sdpAnswer", sdpAnswer);
                session.sendMessage(new TextMessage(response.toString()));

            } catch (IOException e) {
                log.error("SDP 응답 전송 실패", e);
            }
        });
    }

    private void handleIceCandidate(String roomId, String userId, JsonObject jsonMessage) {
        if (!jsonMessage.has("candidate")) {
            log.error("ICE Candidate 정보 없음: {}", jsonMessage);
            return;
        }

        IceCandidate candidate = new Gson().fromJson(jsonMessage.get("candidate"), IceCandidate.class);
        kurentoManager.sendIceCandidates(roomId, userId, candidate);
    }

    private void toggleMediaState(String roomId, String userId, String type, boolean enabled) {
        log.info("{} 공유 상태 변경: {} - {}", type, userId, enabled);
        kurentoManager.updateUserMediaState(roomId, userId, type, enabled);
    }

    private void handleLeave(String roomId, String userId, WebSocketSession session) {
        log.info("사용자 퇴장: {} (방: {})", userId, roomId);
        kurentoManager.removeUser(roomId, userId);
        sessions.remove(session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info("WebSocket 연결 종료: {}", session.getId());
        sessions.remove(session.getId());
    }
}