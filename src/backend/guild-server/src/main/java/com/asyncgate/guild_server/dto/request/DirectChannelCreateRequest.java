package com.asyncgate.guild_server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DirectChannelCreateRequest {
    private List<String> memberIds;
}
