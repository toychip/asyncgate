package com.asyncgate.user_server.repository;

import com.asyncgate.user_server.domain.Member;
import com.asyncgate.user_server.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findByEmail(String email);

    Optional<Member> findById(String id);

    boolean isExistByEmail(String email);

    boolean isExistById(String id);

    void save(Member member);

    void softDeleteById(String id);

    List<Member> getByMemberIds(List<String> memberIds);
}
