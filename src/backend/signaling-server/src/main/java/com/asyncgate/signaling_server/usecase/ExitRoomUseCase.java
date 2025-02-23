package com.asyncgate.signaling_server.usecase;

public interface ExitRoomUseCase {
    /**
     * 방에서 유저 제거
     *
     * @param roomId
     * @param memberId
     */
    void execute(final String roomId, final String memberId);
}
