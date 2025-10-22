package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "opportunity_status")
public class OpportunityStatus {
    @Id
    private String id;
    private String opportunity_status_name;
    private String opportunity_status_description;
}

