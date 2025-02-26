package com.asyncgate.signaling_server.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member implements Identifiable {

    private final String id; // 고유한 식별자
    private final String userId; // 사용자의 ID
    private String roomId; // 사용자가 속한 방 ID

    // 미디어 상태
    private boolean isMicEnabled;
    private boolean isCameraEnabled;
    private boolean isScreenSharingEnabled;

    @Builder
    public Member(final String id, final String userId, final String roomId, final boolean isMicEnabled, final boolean isCameraEnabled, final boolean isScreenSharingEnabled) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.isMicEnabled = isMicEnabled;
        this.isCameraEnabled = isCameraEnabled;
        this.isScreenSharingEnabled = isScreenSharingEnabled;
    }

    public static Member create(final String id, final String userId, final String roomId) {
        return Member.builder()
                .id(id)
                .userId(userId)
                .roomId(roomId)
                .isMicEnabled(false)
                .isCameraEnabled(false)
                .isScreenSharingEnabled(false)
                .build();
    }

    // 미디어 상태 업데이트
    public void updateMediaState(String type, boolean enabled) {
        switch (type) {
            case "mic":
                this.isMicEnabled = enabled;
                break;
            case "camera":
                this.isCameraEnabled = enabled;
                break;
            case "screen":
                this.isScreenSharingEnabled = enabled;
                break;
            default:
                throw new IllegalArgumentException("잘못된 미디어 타입: " + type);
        }
    }
}