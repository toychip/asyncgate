package com.asyncgate.signaling_server.service;

import com.asyncgate.signaling_server.domain.ChatRoom;
import com.asyncgate.signaling_server.domain.Member;
import com.asyncgate.signaling_server.dto.request.CreateRoomRequest;
import com.asyncgate.signaling_server.repository.ChatRoomRepository;
import com.asyncgate.signaling_server.repository.MemberRepository;
import com.asyncgate.signaling_server.signaling.KurentoManager;
import com.asyncgate.signaling_server.support.utility.DomainUtil;
import com.asyncgate.signaling_server.usecase.CreateRoomUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kurento.client.MediaPipeline;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateRoomService implements CreateRoomUseCase {

    private final KurentoManager kurentoManager;
    private final ChatRoomRepository chatRoomRepository;

    private final MemberRepository memberRepository;

    /**
     * 방 생성
     */
    @Override
    public void execute(final CreateRoomRequest request, final String userId) {
        // Kurento Media Pipeline 생성
        MediaPipeline pipeline = kurentoManager.getOrCreatePipeline(request.roomId());
        Member member = Member.create(userId, request.roomId(), pipeline.getId());

        ChatRoom room = ChatRoom.create(request.roomId(), pipeline.getId(), member.getId());

        chatRoomRepository.save(DomainUtil.ChatRoomMapper.toEntity(room));
    }
}
