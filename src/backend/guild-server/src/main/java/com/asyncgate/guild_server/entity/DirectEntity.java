package com.asyncgate.guild_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "direct")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DirectEntity {

    @Id
    private String id;
    private String name;

    @Builder
    private DirectEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
