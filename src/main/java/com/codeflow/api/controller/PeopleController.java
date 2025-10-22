package com.codeflow.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeflow.api.model.People;
import com.codeflow.api.repository.PeopleRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleRepository repo;

    public PeopleController(PeopleRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<People> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public People getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Cadastro nao encontrado: " + id));
    }

    @PostMapping
    public People create(@RequestBody People user) {
        return repo.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public People update(@PathVariable String id, @RequestBody People updatedUser) {
        return repo.findById(id)
                .map(user -> {
                    user.setProfile_image(updatedUser.getProfile_image());
                    user.setRegistration_number(updatedUser.getRegistration_number());
                    user.setName(updatedUser.getName());
                    user.setPhone_number(updatedUser.getPhone_number());
                    user.setCpf(updatedUser.getCpf());
                    user.setRg(updatedUser.getRg());
                    user.setDate_birth(updatedUser.getDate_birth());
                    user.setSex(updatedUser.getSex());
                    user.setReplacement(updatedUser.getReplacement());
                    user.setRecruitment_data(updatedUser.getRecruitment_data());
                    user.setAdimission_date(updatedUser.getAdimission_date());
                    user.setDemissal_date(updatedUser.getDemissal_date());
                    user.setObservations(updatedUser.getObservations());
                    user.setProfessional_references(updatedUser.getProfessional_references());
                    user.setCollaborator_knowledge(updatedUser.getCollaborator_knowledge());
                    user.setLabor_lawsuit(updatedUser.getLabor_lawsuit());
                    user.setCriminal_background(updatedUser.getCriminal_background());
                    user.setExternal_link(updatedUser.getExternal_link());
                    user.setMindsigth_link(updatedUser.getMindsigth_link());
                    user.setCis_link(updatedUser.getCis_link());
                    user.setId_opportunity(updatedUser.getId_opportunity());
                    user.setId_position(updatedUser.getId_position());
                    user.setId_team(updatedUser.getId_team());
                    user.setId_departament(updatedUser.getId_departament());
                    user.setId_base_origin(updatedUser.getId_base_origin());
                    user.setId_demission_type(updatedUser.getId_demission_type());
                    user.setId_demissal_motivation(updatedUser.getId_demissal_motivation());
                    user.setId_education(updatedUser.getId_education());
                    user.setId_recruitment_source(updatedUser.getId_recruitment_source());
                    user.setId_process_stage(updatedUser.getId_process_stage());
                    user.setId_process_status(updatedUser.getId_process_status());
                    return repo.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
        }
}
