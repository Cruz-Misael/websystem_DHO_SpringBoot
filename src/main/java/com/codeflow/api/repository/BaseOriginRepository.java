package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.BaseOrigin;

public interface BaseOriginRepository extends MongoRepository<BaseOrigin, String> {
}
