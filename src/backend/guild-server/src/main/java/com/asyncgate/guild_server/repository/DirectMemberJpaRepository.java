package com.asyncgate.guild_server.repository;

import com.asyncgate.guild_server.entity.DirectMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectMemberJpaRepository extends JpaRepository<DirectMemberEntity, Long> {
}
