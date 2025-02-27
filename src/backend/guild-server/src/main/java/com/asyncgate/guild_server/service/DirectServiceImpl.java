package com.asyncgate.guild_server.service;

import com.asyncgate.guild_server.client.UserClient;
import com.asyncgate.guild_server.client.UserClientInfoResponses;
import com.asyncgate.guild_server.domain.Direct;
import com.asyncgate.guild_server.domain.DirectMember;
import com.asyncgate.guild_server.dto.request.DirectChannelCreateRequest;
import com.asyncgate.guild_server.dto.response.DirectResponse;
import com.asyncgate.guild_server.repository.DirectMemberRepository;
import com.asyncgate.guild_server.repository.DirectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public DirectResponse create(final String currentUserId, final DirectChannelCreateRequest request) {
        List<String> memberIds = new ArrayList<>(request.getMemberIds());
        if (!memberIds.contains(currentUserId)) {
            memberIds.add(currentUserId);
        }

        UserClientInfoResponses usersInfo = userClient.getUsersInfo(memberIds);
        List<String> userNames = usersInfo.responses().stream()
                .map(UserClientInfoResponses.UserClientInfoResponse::name)
                .toList();

        Direct direct = Direct.create(userNames);

        // ToDo memberName 변경시 이벤트 구독하고 수정해야함
        List<DirectMember> directMembers = usersInfo.responses().stream()
                .map(userInfo ->
                        DirectMember.create(direct.getId(), userInfo.userId(), userInfo.name())
                )
                .toList();

        directRepository.save(direct);
        directMemberRepository.saveAll(directMembers);

        return DirectResponse.of(direct.getId(), usersInfo);
    }
}
