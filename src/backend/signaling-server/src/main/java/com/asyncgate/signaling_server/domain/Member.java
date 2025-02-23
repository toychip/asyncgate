package com.asyncgate.signaling_server.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member implements Identifiable {

    private final String id;
    private final String userId;
    private String roomId;

    private boolean isScreenSharing;

    @Builder
    private Member(String id, String userId, String roomId) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
    }

    public static Member create(final String id, final String userId, final String roomId) {
        return Member.builder()
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
