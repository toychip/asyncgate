package com.asyncgate.user_server.domain;

public enum FriendStatus {
    PENDING,
    ACCEPTED,
    REJECTED,

    // 실제 데이터 미사용 x 프론트 반환 전용
    RECEIVED,
}
