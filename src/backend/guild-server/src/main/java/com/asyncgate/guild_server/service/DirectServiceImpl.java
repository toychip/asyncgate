package com.asyncgate.guild_server.service;

import com.asyncgate.guild_server.client.UserClient;
import com.asyncgate.guild_server.client.UserClientInfoResponse;
import com.asyncgate.guild_server.domain.Direct;
import com.asyncgate.guild_server.domain.DirectMember;
import com.asyncgate.guild_server.dto.request.DirectChannelCreateRequest;
import com.asyncgate.guild_server.dto.response.DirectResponse;
import com.asyncgate.guild_server.repository.DirectMemberRepository;
import com.asyncgate.guild_server.repository.DirectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DirectServiceImpl implements DirectService {

    private final UserClient userClient;
    private final DirectRepository directRepository;
    private final DirectMemberRepository directMemberRepository;

    @Override
    @Transactional
    public DirectResponse create(final DirectChannelCreateRequest request) {
        List<String> memberIds = request.getMemberIds();
        List<UserClientInfoResponse> usersInfo = userClient.getUsersInfo(memberIds);
        List<String> userNames = usersInfo.stream()
                .map(UserClientInfoResponse::getName)
                .toList();

        Direct direct = Direct.create(userNames);

        // ToDo memberName 변경시 이벤트 구독하고 수정해야함
        List<DirectMember> directMembers = usersInfo.stream()
                .map(userInfo ->
                        DirectMember.create(direct.getId(), userInfo.getUserId(), userInfo.getName())
                )
                .toList();

        directRepository.save(direct);
        directMemberRepository.saveAll(directMembers);

        return DirectResponse.of(direct.getId(), usersInfo);
    }
}
