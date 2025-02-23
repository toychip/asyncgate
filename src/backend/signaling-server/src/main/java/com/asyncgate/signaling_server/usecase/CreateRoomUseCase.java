package com.asyncgate.signaling_server.usecase;

import com.asyncgate.signaling_server.dto.request.CreateRoomRequest;
import com.asyncgate.signaling_server.support.annotation.UseCase;

@UseCase
public interface CreateRoomUseCase {
    /**
     * 채팅방 생성
     *
     * @param request
     * @param userId
     */
    void execute(final CreateRoomRequest request, final String userId);
}
