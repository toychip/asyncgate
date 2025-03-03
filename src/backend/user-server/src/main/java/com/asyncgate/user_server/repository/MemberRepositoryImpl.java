package com.asyncgate.user_server.repository;

import com.asyncgate.user_server.domain.Member;
import com.asyncgate.user_server.support.utility.DomainUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberQueryDslRepository queryDslRepository;

    @Override
    public void save(final Member member) {
        memberJpaRepository.save(
                DomainUtil.MemberMapper.toEntity(member)
        );
    }

    @Override
    public void softDeleteById(final String id) {

        memberJpaRepository.softDeleteById(id);
    }

    @Override
    public List<Member> getByMemberIds(final List<String> memberIds) {
        return queryDslRepository.getByMemberIds(memberIds).stream()
                .map(DomainUtil.MemberMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Member> findByEmail(final String email) {
        return memberJpaRepository.findByNotDeletedEmail(email)
                .map(DomainUtil.MemberMapper::toDomain);
    }

    @Override
    public Optional<Member> findById(final String id) {
        return memberJpaRepository.findByNotDeletedId(id)
                .map(DomainUtil.MemberMapper::toDomain);
    }

    @Override
    public boolean isExistByEmail(final String email) {
        return memberJpaRepository.findByNotDeletedEmail(email).isPresent();
    }

    @Override
    public boolean isExistById(final String id) {
        return memberJpaRepository.findById(id).isPresent();
    }
}
