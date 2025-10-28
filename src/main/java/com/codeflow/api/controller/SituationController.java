package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.Situation;
import com.codeflow.api.repository.SituationRepository;

@RestController
@RequestMapping("/situation")
public class SituationController {

    private final SituationRepository repo;

    public SituationController(SituationRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<Situation> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Situation getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public Situation create(@RequestBody Situation situation) {
        return repo.save(situation);
    }

    // PUT update
    @PutMapping("/{id}")
    public Situation update(@PathVariable String id, @RequestBody Situation updatedSituation) {
        return repo.findById(id)
                   .map(situation -> {
                       situation.setSituation_name(updatedSituation.getSituation_name());
                       situation.setSituation_description(updatedSituation.getSituation_description());
                       return repo.save(situation);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
