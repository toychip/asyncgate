package com.asyncgate.signaling_server.usecase;

public interface JoinRoomUseCase {
    /**
     * 채팅방 참여
     *
     * @param roomId
     * @param memberId
     */
    void execute(final String roomId, final String memberId);
}
