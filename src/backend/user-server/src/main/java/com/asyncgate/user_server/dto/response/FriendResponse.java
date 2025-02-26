package com.asyncgate.user_server.dto.response;

import com.asyncgate.user_server.domain.Friend;
import com.asyncgate.user_server.domain.FriendStatus;

public record FriendResponse(String id, String userId1, String userId2, String requestedBy, FriendStatus status) {
    public static FriendResponse from(final Friend friend) {
        return new FriendResponse(
                friend.getId(),
                friend.getUserId1(),
                friend.getUserId2(),
                friend.getRequestedBy(),
                friend.getStatus()
        );
    }
}
