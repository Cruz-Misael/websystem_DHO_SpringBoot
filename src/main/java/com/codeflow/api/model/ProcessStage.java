package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "process_stage")
public class ProcessStage {
    @Id
    private String id;
    private String process_stage_name;
    private String process_stage_description;
}

