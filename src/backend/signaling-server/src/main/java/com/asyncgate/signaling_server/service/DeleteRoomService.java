package com.asyncgate.signaling_server.service;

import com.asyncgate.signaling_server.signaling.KurentoManager;
import com.asyncgate.signaling_server.usecase.DeleteRoomUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteRoomService implements DeleteRoomUseCase {

    private final KurentoManager kurentoManager;

    @Override
    public void execute(String roomId) {
        kurentoManager.removeRoom(roomId);
    }
}