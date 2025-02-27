package com.asyncgate.guild_server.repository;

import com.asyncgate.guild_server.entity.DirectMemberEntity;
import com.asyncgate.guild_server.entity.QDirectMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DirectMemberQueryDslRepository {

    private final JPAQueryFactory queryFactory;
    private final QDirectMemberEntity directMemberEntity = QDirectMemberEntity.directMemberEntity;

    public List<DirectMemberEntity> getDirectMessageList(final String currentUserId) {
        return queryFactory
                .select(directMemberEntity)
                .from(directMemberEntity)
                .where(
                        directMemberEntity.memberId.eq(currentUserId),
                        directMemberEntity.deleted.isFalse()
                )
                .fetch();

    }
}
