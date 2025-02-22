package com.asyncgate.signaling_server.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
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

    @Builder.Default
    private Set<String> memberIds = new HashSet<>(); // 참가자 리스트
}
