package com.asyncgate.guild_server.dto.response;

import com.asyncgate.guild_server.client.UserClientInfoResponses;

public record DirectResponse(String directId,UserClientInfoResponses members) {
    public static DirectResponse of(final String directId, final UserClientInfoResponses members) {
        return new DirectResponse(directId, members);
    }
}
