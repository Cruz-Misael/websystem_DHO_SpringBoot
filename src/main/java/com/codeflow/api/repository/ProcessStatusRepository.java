package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.ProcessStatus;

public interface ProcessStatusRepository extends MongoRepository<ProcessStatus, String> {
}
