package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.DemissionMotivation;
import com.codeflow.api.repository.DemissionMotivationRepository;

@RestController
@RequestMapping("/demission_motivation")
public class DemissionMotivationController {

    private final DemissionMotivationRepository repo;

    public DemissionMotivationController(DemissionMotivationRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<DemissionMotivation> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public DemissionMotivation getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public DemissionMotivation create(@RequestBody DemissionMotivation demission_motivation) {
        return repo.save(demission_motivation);
    }

    // PUT update
    @PutMapping("/{id}")
    public DemissionMotivation update(@PathVariable String id, @RequestBody DemissionMotivation updatedDemissionMotivation) {
        return repo.findById(id)
                   .map(demission_motivation -> {
                       demission_motivation.setDemission_motivation_name(updatedDemissionMotivation.getDemission_motivation_name());
                       demission_motivation.setDemission_motivation_description(updatedDemissionMotivation.getDemission_motivation_description());
                       return repo.save(demission_motivation);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
