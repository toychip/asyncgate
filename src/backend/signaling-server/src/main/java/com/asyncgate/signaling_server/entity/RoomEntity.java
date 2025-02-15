package com.asyncgate.signaling_server.entity;

import org.springframework.data.annotation.Id;
import lombok.AccessLevel;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(collection = "room")
public class RoomEntity {

    @Id
    private Long id;

    private String roomId;

    private List<String> userIds;
}
