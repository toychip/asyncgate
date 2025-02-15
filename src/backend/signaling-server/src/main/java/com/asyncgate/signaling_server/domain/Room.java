package com.asyncgate.signaling_server.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Room implements Identifiable {

    private final String id;
    private final String roomId;
    private final List<String> userIds;

    @Builder
    public Room(String id, String roomId, List<String> userIds) {
        this.id = id;
        this.roomId = roomId;
        this.userIds = userIds;
    }

    public static Room create(final String id, final String roomId, final List<String> userIds) {
        return Room.builder()
                .id(id)
                .roomId(roomId)
                .userIds(userIds)
                .build();
    }

    // user 추가
    public void addUser(final String roomId, final String userId) {
        this.userIds.add(userId);
    }
}
