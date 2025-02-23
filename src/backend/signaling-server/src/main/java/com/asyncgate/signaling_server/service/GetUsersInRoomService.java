package com.asyncgate.signaling_server.service;

import com.asyncgate.signaling_server.dto.response.GetUsersInChannelResponse;
import com.asyncgate.signaling_server.signaling.KurentoManager;
import com.asyncgate.signaling_server.usecase.GetUsersInRoomUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetUsersInRoomService implements GetUsersInRoomUseCase {
    private final KurentoManager kurentoManager;

    @Override
    public GetUsersInChannelResponse execute(final String roomId) {
        return GetUsersInChannelResponse.builder()
                .users(kurentoManager.getUsersInChannel(roomId))
                .build();
    }
}
