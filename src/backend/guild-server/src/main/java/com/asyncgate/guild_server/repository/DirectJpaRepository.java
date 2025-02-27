package com.asyncgate.guild_server.repository;

import com.asyncgate.guild_server.entity.DirectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectJpaRepository extends JpaRepository<DirectEntity, String> {
}
