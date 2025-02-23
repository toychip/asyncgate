package com.asyncgate.signaling_server.entity;

import org.springframework.data.annotation.Id;
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

    private String userId;  // 사용자 ID
    private String roomId;  // 참가 중인 방 ID
}
