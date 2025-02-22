package com.asyncgate.signaling_server.repository;

import com.asyncgate.signaling_server.entity.MemberEntity;
import com.asyncgate.signaling_server.exception.FailType;
import com.asyncgate.signaling_server.exception.SignalingServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberMongoRepository memberMongoRepository;

    public MemberEntity save(MemberEntity entity) {
        return memberMongoRepository.save(entity);
    }

    public void delete(MemberEntity entity) {
        memberMongoRepository.delete(entity);
    }

    public MemberEntity findById(String id) {
        return memberMongoRepository.findById(id)
                    .orElseThrow(() -> new SignalingServerException(FailType._MEMBER_NOT_FOUND));
    }
}
