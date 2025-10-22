package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "education")
public class Education {
    @Id
    private String id;
    private String education_name;
    private String education_description;
}

