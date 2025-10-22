package com.codeflow.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.codeflow.api.model.Departament;

public interface DepartamentRepository extends MongoRepository<Departament, String> {
}
