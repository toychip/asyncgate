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
        // 두 사용자 ID를 사전 순으로 정렬하여 저장
        if (requestUserId.compareTo(toUserId) < 0) {
            return new Friend(UUID.randomUUID().toString(), requestUserId, toUserId, requestUserId, FriendStatus.PENDING);
        } else {
            return new Friend(UUID.randomUUID().toString(), toUserId, requestUserId, requestUserId, FriendStatus.PENDING);
        }
    }

    public static Friend of(String id, String userId1, String userId2, String requestedBy, FriendStatus status) {
        return new Friend(id, userId1, userId2, requestedBy, status);
    }

    public void accept() {
        this.status = FriendStatus.ACCEPTED;
    }

    public void reject() {
        this.status = FriendStatus.REJECTED;
    }

}