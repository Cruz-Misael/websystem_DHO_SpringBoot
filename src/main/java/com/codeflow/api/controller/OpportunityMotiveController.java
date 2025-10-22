package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.OpportunityMotive;
import com.codeflow.api.repository.OpportunityMotiveRepository;

@RestController
@RequestMapping("/opportunity_motive")
public class OpportunityMotiveController {

    private final OpportunityMotiveRepository repo;

    public OpportunityMotiveController(OpportunityMotiveRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<OpportunityMotive> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public OpportunityMotive getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public OpportunityMotive create(@RequestBody OpportunityMotive opportunity_motive) {
        return repo.save(opportunity_motive);
    }

    // PUT update
    @PutMapping("/{id}")
    public OpportunityMotive update(@PathVariable String id, @RequestBody OpportunityMotive updatedOpportunityMotive) {
        return repo.findById(id)
                   .map(opportunity_motive -> {
                       opportunity_motive.setOpportunity_motive_name(updatedOpportunityMotive.getOpportunity_motive_name());
                       opportunity_motive.setOpportunity_motive_description(updatedOpportunityMotive.getOpportunity_motive_description());
                       return repo.save(opportunity_motive);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
