package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.Departament;
import com.codeflow.api.repository.DepartamentRepository;

@RestController
@RequestMapping("/departaments")
public class DepartamentController {

    private final DepartamentRepository repo;

    public DepartamentController(DepartamentRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<Departament> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Departament getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public Departament create(@RequestBody Departament departament) {
        return repo.save(departament);
    }

    // PUT update
    @PutMapping("/{id}")
    public Departament update(@PathVariable String id, @RequestBody Departament updatedDepartament) {
        return repo.findById(id)
                   .map(departament -> {
                       departament.setDepartament_name(updatedDepartament.getDepartament_name());
                       departament.setDepartament_description(updatedDepartament.getDepartament_description());
                       return repo.save(departament);
                   })
                   .orElseThrow(() -> new RuntimeException("Posição não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
