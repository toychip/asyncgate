package com.asyncgate.signaling_server.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class KurentoAnswerResponse {

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

    @Builder
    public KurentoAnswerResponse(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
