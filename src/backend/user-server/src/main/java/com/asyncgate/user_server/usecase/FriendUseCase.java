package com.asyncgate.user_server.usecase;

import com.asyncgate.user_server.domain.Member;

public interface FriendUseCase {
    Member getByEmail(String email);
}
