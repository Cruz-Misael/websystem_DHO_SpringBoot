package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.Opportunities;

public interface OpportunitiesRepository extends MongoRepository<Opportunities, String> {
}
