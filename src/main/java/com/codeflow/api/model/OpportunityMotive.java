package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "opportunity_motive")
public class OpportunityMotive {
    @Id
    private String id;
    private String opportunity_motive_name;
    private String opportunity_motive_description;
}

