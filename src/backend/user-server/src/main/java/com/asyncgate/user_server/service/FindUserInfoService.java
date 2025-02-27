package com.asyncgate.user_server.service;

import com.asyncgate.user_server.dto.response.UserClientInfoResponses;
import com.asyncgate.user_server.repository.MemberRepository;
import com.asyncgate.user_server.usecase.FindUserInfoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindUserInfoService implements FindUserInfoUseCase {

    private final MemberRepository memberRepository;

    @Override
    public UserClientInfoResponses getByUserIds(final List<String> memberIds) {
        return UserClientInfoResponses.from(
                memberRepository.getByMemberIds(memberIds)
        );
    }
}
