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
        String id = UUID.randomUUID().toString();

        StringBuilder builder = new StringBuilder();
        for (String memberName : memberNames) {
            builder.append(memberName);
            builder.append(" ");
        }
        String name = builder.toString();
        return new Direct(id, name);
    }

    public void changeName(final String name) {
        this.name = name;
    }

}
