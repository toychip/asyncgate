package com.asyncgate.signaling_server.entity;

import org.springframework.data.annotation.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(collection = "user")
public class UserEntity {

    @Id
    private Long id;

    private String userId;

    private String roomId;
}
