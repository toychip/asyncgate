package com.asyncgate.signaling_server.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ChatRoom implements Identifiable {

    private final String id;
    private final String roomId;
    private final List<String> memberIds;

    @Builder
    public ChatRoom(String id, String roomId, List<String> memberIds) {
        this.id = id;
        this.roomId = roomId;
        this.memberIds = memberIds;
    }

    public static ChatRoom create(final String id, final String roomId, final List<String> userIds) {
        return ChatRoom.builder()
                .id(id)
                .roomId(roomId)
                .memberIds(userIds)
                .build();
    }

    // user 추가
    public void addUser(final String roomId, final String userId) {
        this.memberIds.add(userId);
    }
}
