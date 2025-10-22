package com.codeflow.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.codeflow.api.model.Opportunities;
import com.codeflow.api.repository.OpportunitiesRepository;

@RestController
@RequestMapping("/opportunities")
public class OpportunitiesController {

    private final OpportunitiesRepository repo;

    public OpportunitiesController(OpportunitiesRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Opportunities> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Opportunities getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Oportunidade não encontrada: " + id));
    }

    @PostMapping
    public Opportunities create(@RequestBody Opportunities opportunity) {
        return repo.save(opportunity);
    }

    @PutMapping("/{id}")
    public Opportunities update(@PathVariable String id, @RequestBody Opportunities updated) {
        return repo.findById(id)
                .map(o -> {
                    o.setOpen_opportunity_date(updated.getOpen_opportunity_date());
                    o.setPosition_id(updated.getPosition_id());
                    o.setTeam_id(updated.getTeam_id());
                    o.setDepartament_id(updated.getDepartament_id());
                    o.setOpportunity_motive_id(updated.getOpportunity_motive_id());
                    o.setReplaced_person_id(updated.getReplaced_person_id());
                    o.setBase_origin_id(updated.getBase_origin_id());
                    o.setOpportunity_status_id(updated.getOpportunity_status_id());
                    o.setDeadline_sla_days(updated.getDeadline_sla_days());
                    o.setAccept_date(updated.getAccept_date());
                    o.setResponsible_recruiter_id(updated.getResponsible_recruiter_id());
                    o.setObservations(updated.getObservations());
                    return repo.save(o);
                })
                .orElseThrow(() -> new RuntimeException("Oportunidade não encontrada com ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}