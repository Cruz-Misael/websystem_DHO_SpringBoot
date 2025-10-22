package com.codeflow.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codeflow.api.model.Team;
import com.codeflow.api.repository.TeamRepository;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamRepository repo;

    public TeamController(TeamRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<Team> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Team getById(@PathVariable String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Equipe não encontrada com ID: " + id));
    }

    // POST create
    @PostMapping
    public Team create(@RequestBody Team team) {
        return repo.save(team);
    }

    // PUT update
    @PutMapping("/{id}")
    public Team update(@PathVariable String id, @RequestBody Team updatedTeam) {
        return repo.findById(id)
                   .map(team -> {
                       team.setTeam_name(updatedTeam.getTeam_name());
                       team.setTeam_description(updatedTeam.getTeam_description());
                       team.setManager_id(updatedTeam.getManager_id());
                       return repo.save(team);
                   })
                   .orElseThrow(() -> new RuntimeException("Equipe não encontrada com ID: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
