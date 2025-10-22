package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "base_origin")
public class BaseOrigin {
    @Id
    private String id;
    private String base_origin_name;
    private String base_origin_description;
}

