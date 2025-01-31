package com.asyncgate.user_server.usecase;

import com.asyncgate.user_server.dto.request.RegisterTemporaryMemberRequestDto;
import com.asyncgate.user_server.support.annotation.UseCase;

@UseCase
public interface RegisterTemporaryMemberUseCase {
    /**
     * 회원가입
     *
     * @param requestDto (email, password, name, nickname, birth)
     */
    void execute(RegisterTemporaryMemberRequestDto requestDto);
}
