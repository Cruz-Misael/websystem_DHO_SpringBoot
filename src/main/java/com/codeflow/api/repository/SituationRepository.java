package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.Situation;

public interface SituationRepository extends MongoRepository<Situation, String> {
}
