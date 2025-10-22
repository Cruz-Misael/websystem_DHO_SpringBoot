package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.BaseOrigin;
import com.codeflow.api.repository.BaseOriginRepository;

@RestController
@RequestMapping("/base_origins")
public class BaseOriginController {

    private final BaseOriginRepository repo;

    public BaseOriginController(BaseOriginRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<BaseOrigin> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public BaseOrigin getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public BaseOrigin create(@RequestBody BaseOrigin base_origin) {
        return repo.save(base_origin);
    }

    // PUT update
    @PutMapping("/{id}")
    public BaseOrigin update(@PathVariable String id, @RequestBody BaseOrigin updatedBaseOrigin) {
        return repo.findById(id)
                   .map(base_origin -> {
                       base_origin.setBase_origin_name(updatedBaseOrigin.getBase_origin_name());
                       base_origin.setBase_origin_description(updatedBaseOrigin.getBase_origin_description());
                       return repo.save(base_origin);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
