package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.OpportunityMotive;

public interface OpportunityMotiveRepository extends MongoRepository<OpportunityMotive, String> {
}
