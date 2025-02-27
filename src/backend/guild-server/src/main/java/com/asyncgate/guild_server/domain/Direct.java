package com.asyncgate.guild_server.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Direct {

    private final String id;
    private String name;

    @Builder
    private Direct(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Direct create(final List<String> memberNames) {
        return Direct.builder()
                .id(UUID.randomUUID().toString())
                .name(String.join(" ", memberNames))
                .build();
    }

    public void changeName(final String name) {
        this.name = name;
    }

}
