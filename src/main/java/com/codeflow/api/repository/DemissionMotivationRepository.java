package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.DemissionMotivation;

public interface DemissionMotivationRepository extends MongoRepository<DemissionMotivation, String> {
}
