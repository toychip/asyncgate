package com.asyncgate.signaling_server.usecase;

import com.asyncgate.signaling_server.support.annotation.UseCase;

@UseCase
public interface DeleteRoomUseCase {

    void execute(String roomId);
}
