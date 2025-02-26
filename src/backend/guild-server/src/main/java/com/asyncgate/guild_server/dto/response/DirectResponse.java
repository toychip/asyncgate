package com.asyncgate.guild_server.dto.response;

import com.asyncgate.guild_server.client.UserClientInfoResponse;

import java.util.List;

public record DirectResponse(String directId, List<UserClientInfoResponse> members) {
    public static DirectResponse of(final String directId, final List<UserClientInfoResponse> members) {
        return new DirectResponse(directId, members);
    }
}
