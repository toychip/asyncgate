package com.asyncgate.signaling_server.repository;

import com.asyncgate.signaling_server.entity.ChatRoomEntity;

public interface ChatRoomRepository {

    ChatRoomEntity save(ChatRoomEntity room);

    ChatRoomEntity findById(String id);

    void delete(ChatRoomEntity room);
}
