package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.RecruitmentSource;
import com.codeflow.api.repository.RecruitmentSourceRepository;

@RestController
@RequestMapping("/recruitment_source")
public class RecruitmentSourceController {

    private final RecruitmentSourceRepository repo;

    public RecruitmentSourceController(RecruitmentSourceRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<RecruitmentSource> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public RecruitmentSource getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public RecruitmentSource create(@RequestBody RecruitmentSource recruitment_source) {
        return repo.save(recruitment_source);
    }

    // PUT update
    @PutMapping("/{id}")
    public RecruitmentSource update(@PathVariable String id, @RequestBody RecruitmentSource updatedRecruitmentSource) {
        return repo.findById(id)
                   .map(recruitment_source -> {
                       recruitment_source.setRecruitment_source_name(updatedRecruitmentSource.getRecruitment_source_name());
                       recruitment_source.setRecruitment_source_description(updatedRecruitmentSource.getRecruitment_source_description());
                       return repo.save(recruitment_source);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
