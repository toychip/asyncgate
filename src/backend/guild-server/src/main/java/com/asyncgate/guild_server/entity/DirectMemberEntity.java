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
@Table(name = "direct_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DirectMemberEntity extends BaseEntity {

    @Id
    private String id;
    private String directId;
    private String memberId;
    private String memberName;

    @Builder
    private DirectMemberEntity(String id, String directId, String memberId, String memberName) {
        this.id = id;
        this.directId = directId;
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
