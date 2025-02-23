package com.asyncgate.signaling_server.service;

import com.asyncgate.signaling_server.domain.ChatRoom;
import com.asyncgate.signaling_server.dto.request.CreateRoomRequest;
import com.asyncgate.signaling_server.repository.ChatRoomRepository;
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

    /**
     * 방 생성
     */
    @Override
    public void execute(final CreateRoomRequest request) {
        System.out.println("CreateRoomService.execute");
        // room id 출력
        System.out.println("room id: " + request.roomId());
        // Kurento Media Pipeline 생성
        MediaPipeline pipeline = kurentoManager.getOrCreatePipeline(request.roomId());

        System.out.println("create pipeline: " + pipeline);

        ChatRoom room = ChatRoom.create(request.roomId(), pipeline.getId());

        chatRoomRepository.save(DomainUtil.ChatRoomMapper.toEntity(room));
    }
}
