package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "demission_motivation")
public class DemissionMotivation {
    @Id
    private String id;
    private String demission_motivation_name;
    private String demission_motivation_description;
}

