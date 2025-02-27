package com.asyncgate.guild_server.service;

import com.asyncgate.guild_server.dto.request.DirectChannelCreateRequest;
import com.asyncgate.guild_server.dto.response.DirectResponse;

public interface DirectService {
    DirectResponse create(String currentUserId, DirectChannelCreateRequest request);
}
