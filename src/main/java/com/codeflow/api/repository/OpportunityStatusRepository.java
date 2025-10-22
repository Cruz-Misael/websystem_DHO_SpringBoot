package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.OpportunityStatus;

public interface OpportunityStatusRepository extends MongoRepository<OpportunityStatus, String> {
}
