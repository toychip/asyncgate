package com.asyncgate.signaling_server.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User implements Identifiable {

    private final String id;
    private final String userId;
    private String roomId;

    @Builder
    public User(String id, String userId, String roomId) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
    }

    public static User create(final String id, final String userId, final String roomId) {
        return User.builder()
                .id(id)
                .userId(userId)
                .roomId(roomId)
                .build();
    }

    // room 업데이트
    public void updateRoom(final String roomId) {
        this.roomId = roomId;
    }
}
