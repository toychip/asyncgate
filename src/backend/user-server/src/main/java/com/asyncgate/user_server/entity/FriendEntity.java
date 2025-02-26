package com.asyncgate.user_server.entity;

import com.asyncgate.user_server.domain.FriendStatus;
import com.asyncgate.user_server.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "friend", indexes = {
        @Index(name = "idx_user1_user2", columnList = "userId1, userId2"),
        @Index(name = "idx_user2_user1", columnList = "userId2, userId1")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendEntity extends BaseEntity {

    @Id
    private String id;

    @Column(name = "userId1", nullable = false)
    private String userId1;

    @Column(name = "userId2", nullable = false)
    private String userId2;

    @Column(name = "requested_by", nullable = false)
    private String requestedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FriendStatus status;

    @Builder
    public FriendEntity(String id, String userId1, String userId2, String requestedBy, FriendStatus status) {
        this.id = id;
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.requestedBy = requestedBy;
        this.status = status;
    }
}

