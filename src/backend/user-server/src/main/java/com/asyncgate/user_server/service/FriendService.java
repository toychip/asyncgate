package com.asyncgate.user_server.service;

import com.asyncgate.user_server.domain.Member;
import com.asyncgate.user_server.exception.FailType;
import com.asyncgate.user_server.exception.UserServerException;
import com.asyncgate.user_server.repository.FriendRepository;
import com.asyncgate.user_server.repository.MemberRepository;
import com.asyncgate.user_server.usecase.FriendUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FriendService implements FriendUseCase {

    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    @Override
    public Member getByEmail(final String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new UserServerException(FailType.MEMBER_NOT_FOUND));
    }
}
