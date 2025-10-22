package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.Position;

public interface PositionRepository extends MongoRepository<Position, String> {
}
