package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.Education;
import com.codeflow.api.repository.EducationRepository;

@RestController
@RequestMapping("/education")
public class EducationController {

    private final EducationRepository repo;

    public EducationController(EducationRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<Education> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Education getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public Education create(@RequestBody Education education) {
        return repo.save(education);
    }

    // PUT update
    @PutMapping("/{id}")
    public Education update(@PathVariable String id, @RequestBody Education updatedEducation) {
        return repo.findById(id)
                   .map(education -> {
                       education.setEducation_name(updatedEducation.getEducation_name());
                       education.setEducation_description(updatedEducation.getEducation_description());
                       return repo.save(education);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
