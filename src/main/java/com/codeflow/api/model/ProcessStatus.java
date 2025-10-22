package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "process_status")
public class ProcessStatus {
    @Id
    private String id;
    private String process_status_name;
    private String process_status_description;
}

