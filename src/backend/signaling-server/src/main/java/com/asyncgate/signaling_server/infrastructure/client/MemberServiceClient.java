package com.asyncgate.signaling_server.infrastructure.client;

import com.asyncgate.signaling_server.domain.Member;
import com.asyncgate.signaling_server.support.annotation.UseCase;

@UseCase
public interface MemberServiceClient {
    Member fetchMemberById(String userId, String roomId);
}