package com.codeflow.api.repository;

import com.codeflow.api.model.People;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepository extends MongoRepository<People, String> {
}
