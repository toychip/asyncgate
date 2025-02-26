package com.asyncgate.user_server.repository;

import com.asyncgate.user_server.domain.Friend;

import java.util.List;

public interface FriendRepository {
    Friend findById(String id);

    Friend save(Friend entity);

    void deleteById(String friendId);

    List<Friend> findSentFriendRequests(String requestedUserId);

    List<Friend> findReceivedFriendRequests(String userId);

    List<Friend> findFriendsByUserId(String userId);
}
