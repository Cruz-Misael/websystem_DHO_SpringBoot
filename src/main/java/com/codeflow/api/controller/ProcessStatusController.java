package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.ProcessStatus;
import com.codeflow.api.repository.ProcessStatusRepository;

@RestController
@RequestMapping("/process_status")
public class ProcessStatusController {

    private final ProcessStatusRepository repo;

    public ProcessStatusController(ProcessStatusRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<ProcessStatus> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public ProcessStatus getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public ProcessStatus create(@RequestBody ProcessStatus process_status) {
        return repo.save(process_status);
    }

    // PUT update
    @PutMapping("/{id}")
    public ProcessStatus update(@PathVariable String id, @RequestBody ProcessStatus updatedProcessStatus) {
        return repo.findById(id)
                   .map(process_status -> {
                       process_status.setProcess_status_name(updatedProcessStatus.getProcess_status_name());
                       process_status.setProcess_status_description(updatedProcessStatus.getProcess_status_description());
                       return repo.save(process_status);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
