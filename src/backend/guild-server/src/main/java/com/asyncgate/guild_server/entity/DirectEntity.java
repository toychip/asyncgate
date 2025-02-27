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

    @Builder
    private DirectEntity(String id) {
        this.id = id;
    }
}
