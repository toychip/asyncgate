package com.asyncgate.signaling_server.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {

    @Id
    private String id;
    private String userId;
    private String roomId;
    private boolean isMuted;
    private boolean isVideoEnabled;
}
