package com.asyncgate.signaling_server.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonPropertyOrder({"httpStatus", "message", "time", "result"})
public class SuccessResponse<T> {

    @JsonProperty("httpStatus")
    private final int httpStatus;

    @JsonProperty("message")
    private final String message;

    @JsonProperty("time")
    private final LocalDateTime time;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("result")
    private final T result;

    private SuccessResponse(final int httpStatus, final String message, final T result) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.time = LocalDateTime.now();
        this.result = result;
    }

    public static <T> SuccessResponse<T> ok(final T result) {
        return new SuccessResponse<>(
                SuccessResponseStatus.SUCCESS.getHttpsStatusCode(),
                SuccessResponseStatus.SUCCESS.getMessage(),
                result
        );
    }

    public static <T> SuccessResponse<T> created(final T result) {
        return new SuccessResponse<>(
                SuccessResponseStatus.CREATED.getHttpsStatusCode(),
                SuccessResponseStatus.CREATED.getMessage(),
                result
        );
    }

    public static <T> SuccessResponse<T> accepted(final T result) {
        return new SuccessResponse<>(
                SuccessResponseStatus.ACCEPTED.getHttpsStatusCode(),
                SuccessResponseStatus.ACCEPTED.getMessage(),
                result
        );
    }
}
