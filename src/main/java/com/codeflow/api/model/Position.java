package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "position")
public class Position {
    @Id
    private String id;
    private String position_name;
    private String position_description;
}

