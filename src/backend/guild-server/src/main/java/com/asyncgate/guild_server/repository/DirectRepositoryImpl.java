package com.asyncgate.guild_server.repository;

import com.asyncgate.guild_server.domain.Direct;
import com.asyncgate.guild_server.support.utility.DomainUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DirectRepositoryImpl implements DirectRepository {
    private final DirectJpaRepository jpaRepository;

    @Override
    public void save(final Direct direct) {
        jpaRepository.save(
                DomainUtil.DirectMapper.toEntity(direct)
        );
    }
}
