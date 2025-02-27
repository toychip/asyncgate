package com.asyncgate.guild_server.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Direct {

    private final String id;
    private LocalDateTime createdDate;

    @Builder
    private Direct(String id, LocalDateTime createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public static Direct create() {
        return Direct.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }
}
