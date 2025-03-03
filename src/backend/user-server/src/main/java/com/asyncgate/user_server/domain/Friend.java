package com.asyncgate.user_server.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Friend {
    private final String id;
    private final String userId1;
    private final String userId2;
    private final String requestedBy;
    private FriendStatus status;

    private Friend(String id, String userId1, String userId2, String requestedBy, FriendStatus status) {
        this.id = id;
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.requestedBy = requestedBy;
        this.status = status;
    }

    public static Friend create(String requestUserId, String toUserId) {
        String lowerUserId = getLowerUserId(requestUserId, toUserId);
        String higherUserId = getHigherUserId(requestUserId, toUserId);
        // 요청을 보낸 쪽의 ID는 요청자(requestedBy)로 설정합니다.
        return new Friend(UUID.randomUUID().toString(), lowerUserId, higherUserId, requestUserId, FriendStatus.PENDING);
    }

    public static Friend of(String id, String userId1, String userId2, String requestedBy, FriendStatus status) {
        return new Friend(id, userId1, userId2, requestedBy, status);
    }

    public static String getLowerUserId(String userId1, String userId2) {
        return userId1.compareTo(userId2) < 0 ? userId1 : userId2;
    }

    public static String getHigherUserId(String userId1, String userId2) {
        return userId1.compareTo(userId2) < 0 ? userId2 : userId1;
    }


    public void accept() {
        this.status = FriendStatus.ACCEPTED;
    }

    public void reject() {
        this.status = FriendStatus.REJECTED;
    }

}