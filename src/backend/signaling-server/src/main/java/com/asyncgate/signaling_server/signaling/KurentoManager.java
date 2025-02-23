package com.asyncgate.signaling_server.signaling;

import lombok.RequiredArgsConstructor;
import org.kurento.client.KurentoClient;
import org.kurento.client.MediaPipeline;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.kurento.jsonrpc.client.JsonRpcClient.log;

@Component
@RequiredArgsConstructor
public class KurentoManager {
    private final KurentoClient kurentoClient;
    private final Map<String, MediaPipeline> pipelines = new ConcurrentHashMap<>();

    public MediaPipeline getOrCreatePipeline(String roomId) {
        if (kurentoClient == null) {
            throw new IllegalStateException("🚨 KurentoClient is NULL! KMS가 실행 중인지 확인하세요.");
        }

        log.info("KurentoManager.getOrCreatePipeline: {}", kurentoClient);
        return pipelines.computeIfAbsent(roomId, id -> kurentoClient.createMediaPipeline());
    }

    public void releasePipeline(String roomId) {
        MediaPipeline pipeline = pipelines.remove(roomId);
        if (pipeline != null) {
            pipeline.release();
        }
    }
}