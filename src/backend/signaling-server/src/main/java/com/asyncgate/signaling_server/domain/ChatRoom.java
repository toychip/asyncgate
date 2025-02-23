package com.asyncgate.signaling_server.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

@Getter
public class ChatRoom {
    private final String id;
    private final String pipelineId;
    private final Set<String> memberIds;

    @Builder
    private ChatRoom(final String id, final String pipelineId, final Set<String> memberIds) {
        this.id = id;
        this.pipelineId = pipelineId;
        this.memberIds = memberIds != null ? new HashSet<>(memberIds) : new HashSet<>();
    }

    public static ChatRoom create(final String id, final String pipelineId, final String memberId) {
        Set<String> memberIds = new HashSet<>();
        memberIds.add(memberId); // 초기 멤버 추가

        return new ChatRoom(id, pipelineId, memberIds);
    }

    // 멤버 추가 메서드
    public void addMember(String memberId) {
        this.memberIds.add(memberId);
    }

    // 멤버 삭제 메서드
    public void removeMember(String memberId) {
        this.memberIds.remove(memberId);
    }
}