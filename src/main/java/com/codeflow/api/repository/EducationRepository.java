package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.Education;

public interface EducationRepository extends MongoRepository<Education, String> {
}
