package com.asyncgate.signaling_server.usecase;

import com.asyncgate.signaling_server.dto.response.GetUsersInChannelResponse;

public interface GetUsersInRoomUseCase {
    /**
     * 채팅방에 있는 유저 조회
     *
     * @param roomId
     */
    GetUsersInChannelResponse execute(final String roomId);
}
