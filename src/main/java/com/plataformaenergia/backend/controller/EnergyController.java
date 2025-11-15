package com.plataformaenergia.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.plataformaenergia.backend.model.Energy;
import com.plataformaenergia.backend.repository.EnergyRepository;

@RestController
@RequestMapping("/api/energy")
public class EnergyController {

    private final EnergyRepository repo;

    public EnergyController(EnergyRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Energy> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Energy create(@RequestBody Energy energy) {
        return repo.save(energy);
    }

    @GetMapping("/{id}")
    public Energy getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }
}
