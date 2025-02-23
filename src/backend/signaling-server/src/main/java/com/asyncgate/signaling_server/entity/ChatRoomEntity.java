package com.asyncgate.signaling_server.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Document(collection = "room")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoomEntity {

    @Id
    private String id;

    private String roomId;

    private String pipelineId;

    // 참여 멤버 리스트
    private Set<String> memberIds;

    private LocalDateTime createdAt;
}
