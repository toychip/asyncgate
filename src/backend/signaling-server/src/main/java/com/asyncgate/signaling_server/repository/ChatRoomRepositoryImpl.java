package com.asyncgate.signaling_server.repository;

import com.asyncgate.signaling_server.entity.ChatRoomEntity;
import com.asyncgate.signaling_server.exception.FailType;
import com.asyncgate.signaling_server.exception.SignalingServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ChatRoomRepositoryImpl implements ChatRoomRepository {
    private final ChatRoomMongoRepository chatRoomMongoRepository;

    public ChatRoomEntity save(ChatRoomEntity entity) {
        return chatRoomMongoRepository.save(entity);
    }

    public void delete(ChatRoomEntity entity) {
        chatRoomMongoRepository.delete(entity);
    }

    public ChatRoomEntity findById(String id) {
        return chatRoomMongoRepository.findById(id)
                .orElseThrow(() -> new SignalingServerException(FailType._ROOM_NOT_FOUND));
    }
}
