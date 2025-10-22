package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.Team;

public interface TeamRepository extends MongoRepository<Team, String> {
}
