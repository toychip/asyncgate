package com.asyncgate.user_server.repository;

import com.asyncgate.user_server.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendJpaRepository extends JpaRepository<FriendEntity, String> {

    Optional<FriendEntity> findByIdAndDeletedFalse(String id);
}
