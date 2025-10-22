package com.codeflow.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "opportunities")
public class Opportunities {

    @Id
    private String id;
    private String open_opportunity_date;
    private String position_id;
    private String team_id;
    private String departament_id;
    private String opportunity_motive_id;
    private String replaced_person_id;
    private String base_origin_id;
    private String opportunity_status_id;
    private Integer deadline_sla_days;
    private String accept_date;
    private String responsible_recruiter_id;
    private String observations;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getOpen_opportunity_date() {
        return open_opportunity_date;
    }
    public void setOpen_opportunity_date(String open_opportunity_date) {
        this.open_opportunity_date = open_opportunity_date;
    }

    public String getPosition_id() {
        return position_id;
    }
    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getTeam_id() {
        return team_id;
    }
    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getDepartament_id() {
        return departament_id;
    }
    public void setDepartament_id(String departament_id) {
        this.departament_id = departament_id;
    }

    public String getOpportunity_motive_id() {
        return opportunity_motive_id;
    }
    public void setOpportunity_motive_id(String opportunity_motive_id) {
        this.opportunity_motive_id = opportunity_motive_id;
    }

    public String getReplaced_person_id() {
        return replaced_person_id;
    }
    public void setReplaced_person_id(String replaced_person_id) {
        this.replaced_person_id = replaced_person_id;
    }

    public String getBase_origin_id() {
        return base_origin_id;
    }
    public void setBase_origin_id(String base_origin_id) {
        this.base_origin_id = base_origin_id;
    }

    public String getOpportunity_status_id() {
        return opportunity_status_id;
    }
    public void setOpportunity_status_id(String opportunity_status_id) {
        this.opportunity_status_id = opportunity_status_id;
    }

    public Integer getDeadline_sla_days() {
        return deadline_sla_days;
    }
    public void setDeadline_sla_days(Integer deadline_sla_days) {
        this.deadline_sla_days = deadline_sla_days;
    }

    public String getAccept_date() {
        return accept_date;
    }
    public void setAccept_date(String accept_date) {
        this.accept_date = accept_date;
    }

    public String getResponsible_recruiter_id() {
        return responsible_recruiter_id;
    }
    public void setResponsible_recruiter_id(String responsible_recruiter_id) {
        this.responsible_recruiter_id = responsible_recruiter_id;
    }

    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }
}
