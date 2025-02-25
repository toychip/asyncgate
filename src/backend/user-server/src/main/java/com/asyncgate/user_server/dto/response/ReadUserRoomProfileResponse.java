package com.asyncgate.user_server.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

public class ReadUserRoomProfileResponse {
    // 유저의 id, 프로필 사진, 닉네임을 반환
    @JsonProperty("id")
    @NotBlank
    private String id;

    @JsonProperty("profile_image_url")
    @NotBlank
    private String profileImageUrl;

    @JsonProperty("nickname")
    @NotBlank
    private String nickname;

    @Builder
    public ReadUserRoomProfileResponse(
            String id,
            String profileImageUrl,
            String nickname
    ) {
        this.id = id;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }
}
