package com.asyncgate.signaling_server.usecase;

import com.asyncgate.signaling_server.dto.request.CreateRoomRequest;
import com.asyncgate.signaling_server.support.annotation.UseCase;

@UseCase
public interface CreateRoomUseCase {
    /**
     * 채팅방 생성
     *
     * @param request
     */
    void execute(final CreateRoomRequest request);
}
