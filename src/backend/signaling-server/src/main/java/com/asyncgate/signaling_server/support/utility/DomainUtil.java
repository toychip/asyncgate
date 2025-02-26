package com.asyncgate.signaling_server.support.utility;

import com.asyncgate.signaling_server.domain.ChatRoom;
import com.asyncgate.signaling_server.domain.Member;
import com.asyncgate.signaling_server.entity.ChatRoomEntity;
import com.asyncgate.signaling_server.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DomainUtil {
    public static class MemberMapper {
        public static MemberEntity toEntity(final Member member) {
            return MemberEntity.builder()
                    .id(member.getId())
                    .userId(member.getUserId())
                    .roomId(member.getRoomId())
                    .isMicEnabled(member.isMicEnabled())
                    .isCameraEnabled(member.isCameraEnabled())
                    .isScreenSharingEnabled(member.isScreenSharingEnabled())
                    .build();
        }

        public static Member toDomain(final MemberEntity entity) {
            return Member.builder()
                    .id(entity.getId())
                    .userId(entity.getUserId())
                    .roomId(entity.getRoomId())
                    .isMicEnabled(entity.isMicEnabled())
                    .isCameraEnabled(entity.isCameraEnabled())
                    .isScreenSharingEnabled(entity.isScreenSharingEnabled())
                    .build();
        }
    }

    public static class ChatRoomMapper {
        public static ChatRoomEntity toEntity(final ChatRoom chatRoom) {
            return ChatRoomEntity.builder()
                    .id(chatRoom.getId())
                    .pipelineId(chatRoom.getPipelineId())
                    .memberIds(new HashSet<>(chatRoom.getMemberIds()))
                    .build();
        }

        public static ChatRoom toDomain(final ChatRoomEntity entity) {
            return ChatRoom.builder()
                    .id(entity.getId())
                    .pipelineId(entity.getPipelineId())
                    .memberIds(entity.getMemberIds())
                    .build();
        }
    }
}
