package com.asyncgate.guild_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DirectMemberEntity {

    @Id
    private String id;
    private String memberId;
    private String memberName;

    @Builder
    private DirectMemberEntity(String id, String memberId, String memberName) {
        this.id = id;
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
