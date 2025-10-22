package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.OpportunityStatus;
import com.codeflow.api.repository.OpportunityStatusRepository;

@RestController
@RequestMapping("/opportunity_status")
public class OpportunityStatusController {

    private final OpportunityStatusRepository repo;

    public OpportunityStatusController(OpportunityStatusRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<OpportunityStatus> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public OpportunityStatus getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public OpportunityStatus create(@RequestBody OpportunityStatus opportunity_status) {
        return repo.save(opportunity_status);
    }

    // PUT update
    @PutMapping("/{id}")
    public OpportunityStatus update(@PathVariable String id, @RequestBody OpportunityStatus updatedOpportunityStatus) {
        return repo.findById(id)
                   .map(opportunity_status -> {
                       opportunity_status.setOpportunity_status_name(updatedOpportunityStatus.getOpportunity_status_name());
                       opportunity_status.setOpportunity_status_description(updatedOpportunityStatus.getOpportunity_status_description());
                       return repo.save(opportunity_status);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
