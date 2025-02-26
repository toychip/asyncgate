package com.asyncgate.signaling_server.repository;

import com.asyncgate.signaling_server.entity.MemberEntity;

public interface MemberRepository {
    MemberEntity save(MemberEntity member);

    MemberEntity findById(String id);

    void delete(MemberEntity member);
}
