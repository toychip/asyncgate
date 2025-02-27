package com.asyncgate.guild_server.repository;

import com.asyncgate.guild_server.domain.Direct;
import com.asyncgate.guild_server.domain.DirectMember;
import com.asyncgate.guild_server.support.utility.DomainUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DirectRepositoryImpl implements DirectRepository {
    private final DirectJpaRepository jpaRepository;
    private final DirectMemberQueryDslRepository queryDslRepository;

    @Override
    public void save(final Direct direct) {
        jpaRepository.save(
                DomainUtil.DirectMapper.toEntity(direct)
        );
    }

    @Override
    public List<DirectMember> getDirectMessageList(final String currentUserId) {
        return queryDslRepository.getDirectMessageList(currentUserId).stream()
                .map(
                        DomainUtil.DirectMemberMapper::toDomain
                )
                .toList();
    }
}
