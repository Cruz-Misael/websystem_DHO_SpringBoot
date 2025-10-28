package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "situation")
public class Situation {
    @Id
    private String id;
    private String situation_name;
    private String situation_description;
}

