package com.asyncgate.signaling_server.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Set;

import java.util.HashSet;

@Getter
public class ChatRoom implements Identifiable {

    private final String id;
    private final String roomId;
    private final String pipelineId;
    private final Set<String> memberIds;
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    private ChatRoom(final String id, final String roomId, final String pipelineId, final Set<String> memberIds) {
        this.id = id;
        this.roomId = roomId;
        this.pipelineId = pipelineId;
        this.memberIds = memberIds;
    }

    public static ChatRoom create(final String roomId, final String pipelineId) {
        String id = UUID.randomUUID().toString();

        return new ChatRoom(id, roomId, pipelineId, new HashSet<>());
    }
}