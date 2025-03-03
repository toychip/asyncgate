package com.asyncgate.user_server.repository;

import com.asyncgate.user_server.domain.Friend;

import java.util.List;

public interface FriendRepository {
    Friend findById(String id);

    Friend save(Friend entity);

    void deleteById(String friendId);

    List<String> findSentFriendRequests(String requestedUserId);

    List<String> findReceivedFriendRequests(String userId);

    List<String> findFriendIdsByUserId(String userId);

    void validNotExists(String userId1, String userId2);

    Friend findIdAndPending(String friendId);
}
