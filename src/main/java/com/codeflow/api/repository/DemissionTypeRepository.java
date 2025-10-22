package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.DemissionType;

public interface DemissionTypeRepository extends MongoRepository<DemissionType, String> {
}
