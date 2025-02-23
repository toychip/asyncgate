package com.asyncgate.signaling_server.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record CreateRoomRequest(
        @JsonProperty("room_id")
        @NotBlank
        String roomId
) {}
