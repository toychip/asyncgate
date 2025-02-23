package com.asyncgate.signaling_server.service;

import com.asyncgate.signaling_server.entity.ChatRoomEntity;
import com.asyncgate.signaling_server.repository.ChatRoomRepository;
import com.asyncgate.signaling_server.usecase.JoinRoomUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinRoomService implements JoinRoomUseCase {

    private final ChatRoomRepository chatRoomRepository;

    /**
     * 방에 유저 추가
     */
    @Override
    public void execute(final String roomId, final String memberId) {
        ChatRoomEntity room = chatRoomRepository.findById(roomId);

        room.getMemberIds().add(memberId);
        chatRoomRepository.save(room);
    }
}
