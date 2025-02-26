package com.asyncgate.signaling_server.repository;

import com.asyncgate.signaling_server.entity.MemberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MemberMongoRepository extends MongoRepository<MemberEntity, String> {
}