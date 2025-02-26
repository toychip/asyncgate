package com.asyncgate.user_server.dto.response;

import com.asyncgate.user_server.domain.Friend;

import java.util.List;

public record FriendsResponse(List<FriendResponse> friends) {
    public static FriendsResponse from(final List<Friend> friendList) {
        List<FriendResponse> responses = friendList.stream()
                .map(FriendResponse::from)
                .toList();
        return new FriendsResponse(responses);
    }
}
