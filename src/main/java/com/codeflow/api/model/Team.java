package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "team")
public class Team {
    @Id
    private String id_team;  // será o ID no MongoDB
    private String team_name;
    private String team_description;
    private String manager_id;
}
