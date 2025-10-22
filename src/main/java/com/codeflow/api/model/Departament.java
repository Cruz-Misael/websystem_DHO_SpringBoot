package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "departament")
public class Departament {
    @Id
    private String id;
    private String departament_name;
    private String departament_description;
}

