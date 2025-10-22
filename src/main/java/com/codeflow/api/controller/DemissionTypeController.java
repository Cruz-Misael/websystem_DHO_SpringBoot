package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.DemissionType;
import com.codeflow.api.repository.DemissionTypeRepository;

@RestController
@RequestMapping("/demission_type")
public class DemissionTypeController {

    private final DemissionTypeRepository repo;

    public DemissionTypeController(DemissionTypeRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<DemissionType> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public DemissionType getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public DemissionType create(@RequestBody DemissionType demission_type) {
        return repo.save(demission_type);
    }

    // PUT update
    @PutMapping("/{id}")
    public DemissionType update(@PathVariable String id, @RequestBody DemissionType updatedDemissionType) {
        return repo.findById(id)
                   .map(demission_type -> {
                       demission_type.setDemission_type_name(updatedDemissionType.getDemission_type_name());
                       demission_type.setDemission_type_description(updatedDemissionType.getDemission_type_description());
                       return repo.save(demission_type);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
