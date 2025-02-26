package com.asyncgate.guild_server.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserClientInfoResponse {

    private String userId;
    private String name;
    private String nickname;
    private String profileImageUrl;
}
