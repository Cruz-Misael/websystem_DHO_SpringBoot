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
    private Integer id_opportunity;
    private Integer id_position;
    private Integer id_team;
    private Integer id_departament;
    private Integer id_base_origin;
    private Integer id_demission_type;
    private Integer id_demissal_motivation;
    private Integer id_education;
    private Integer id_recruitment_source;
    private Integer id_process_stage;
    private Integer id_process_status;
}
