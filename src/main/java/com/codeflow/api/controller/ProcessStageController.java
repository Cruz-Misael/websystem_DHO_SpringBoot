package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.ProcessStage;
import com.codeflow.api.repository.ProcessStageRepository;

@RestController
@RequestMapping("/process_stage")
public class ProcessStageController {

    private final ProcessStageRepository repo;

    public ProcessStageController(ProcessStageRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<ProcessStage> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public ProcessStage getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public ProcessStage create(@RequestBody ProcessStage process_stage) {
        return repo.save(process_stage);
    }

    // PUT update
    @PutMapping("/{id}")
    public ProcessStage update(@PathVariable String id, @RequestBody ProcessStage updatedProcessStage) {
        return repo.findById(id)
                   .map(process_stage -> {
                       process_stage.setProcess_stage_name(updatedProcessStage.getProcess_stage_name());
                       process_stage.setProcess_stage_description(updatedProcessStage.getProcess_stage_description());
                       return repo.save(process_stage);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
