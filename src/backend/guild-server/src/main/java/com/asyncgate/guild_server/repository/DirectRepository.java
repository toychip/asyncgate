package com.asyncgate.guild_server.repository;

import com.asyncgate.guild_server.domain.Direct;
import com.asyncgate.guild_server.domain.DirectMember;

import java.util.List;

public interface DirectRepository {
    void save(Direct direct);

    List<DirectMember> getDirectMessageList(String currentUserId);
}
