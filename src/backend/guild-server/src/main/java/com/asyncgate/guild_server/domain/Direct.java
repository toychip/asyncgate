package com.asyncgate.guild_server.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Direct {

    private final String id;

    @Builder
    private Direct(String id, String name) {
        this.id = id;
    }

    public static Direct create() {
        return Direct.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }
}
