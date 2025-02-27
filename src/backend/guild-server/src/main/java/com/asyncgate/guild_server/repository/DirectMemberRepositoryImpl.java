package com.asyncgate.guild_server.repository;

import com.asyncgate.guild_server.domain.DirectMember;
import com.asyncgate.guild_server.support.utility.DomainUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DirectMemberRepositoryImpl implements DirectMemberRepository {

    private final DirectMemberJpaRepository jpaRepository;

    @Override
    public void saveAll(List<DirectMember> directMembers) {
        jpaRepository.saveAll(
                directMembers.stream()
                        .map(DomainUtil.DirectMemberMapper::toEntity)
                        .toList()
        );
    }
}
