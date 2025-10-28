package com.codeflow.api.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "people")
public class People {
    @Id
    private String id;
    private String profile_image;
    private Integer registration_number;
    private String name;
    private String phone_number;
    private String cpf;
    private String rg;
    private Date date_birth;
    private String sex;
    private Boolean replacement;
    private Date recruitment_data;
    private Date adimission_date;
    private Date demissal_date;
    private String observations;
    private String professional_references;
    private String collaborator_knowledge;
    private String labor_lawsuit;
    private Boolean criminal_background;
    private String external_link;
    private String mindsigth_link;
    private String cis_link;
    private String id_opportunity;
    private String id_position;
    private String id_team;
    private String id_departament;
    private String id_base_origin;
    private String id_demission_type;
    private String id_demissal_motivation;
    private String id_education;
    private String id_recruitment_source;
    private String id_process_stage;
    private String id_process_status;
    private String id_situation;
}
