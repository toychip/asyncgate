package com.asyncgate.signaling_server.repository;

import com.asyncgate.signaling_server.entity.ChatRoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomMongoRepository extends MongoRepository<ChatRoomEntity, String> {
}