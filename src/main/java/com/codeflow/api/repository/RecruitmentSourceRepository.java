package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.RecruitmentSource;

public interface RecruitmentSourceRepository extends MongoRepository<RecruitmentSource, String> {
}
