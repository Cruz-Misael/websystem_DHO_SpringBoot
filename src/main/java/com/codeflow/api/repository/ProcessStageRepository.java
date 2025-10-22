package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.ProcessStage;

public interface ProcessStageRepository extends MongoRepository<ProcessStage, String> {
}
