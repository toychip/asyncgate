package com.asyncgate.guild_server.dto.response;

import java.util.List;

public record DirectResponses(List<DirectResponse> directResponses) {

    public static DirectResponses from(final List<DirectResponse> directResponses) {
        return new DirectResponses(directResponses);
    }
}
