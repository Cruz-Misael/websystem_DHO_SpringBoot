package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.Position;
import com.codeflow.api.repository.PositionRepository;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionRepository repo;

    public PositionController(PositionRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<Position> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Position getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public Position create(@RequestBody Position position) {
        return repo.save(position);
    }

    // PUT update
    @PutMapping("/{id}")
    public Position update(@PathVariable String id, @RequestBody Position updatedPosition) {
        return repo.findById(id)
                   .map(position -> {
                       position.setPosition_name(updatedPosition.getPosition_name());
                       position.setPosition_description(updatedPosition.getPosition_description());
                       return repo.save(position);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
