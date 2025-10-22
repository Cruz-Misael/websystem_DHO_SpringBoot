package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "recruitment_source")
public class RecruitmentSource {
    @Id
    private String id;
    private String recruitment_source_name;
    private String recruitment_source_description;
}

