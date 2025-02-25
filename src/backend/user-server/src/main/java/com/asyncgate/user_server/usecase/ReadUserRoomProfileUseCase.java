package com.asyncgate.user_server.usecase;

import com.asyncgate.user_server.dto.response.ReadUserRoomProfileResponse;
import com.asyncgate.user_server.support.annotation.UseCase;

@UseCase
public interface ReadUserRoomProfileUseCase {

    /**
     * 유저의 채팅방 프로필 조회
     *
     * @param userId
     */
    public ReadUserRoomProfileResponse execute(final String userId);
}
