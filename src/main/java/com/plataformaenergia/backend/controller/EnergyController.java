package com.plataformaenergia.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.plataformaenergia.backend.model.Energy;
import com.plataformaenergia.backend.service.EnergyService;

import java.util.List;

@RestController
@RequestMapping("/api/energy")
public class EnergyController {

    @Autowired
    private EnergyService energyService;

    @GetMapping
    public List<Energy> getAll() {
        return energyService.getAll();
    }

    @PostMapping
    public Energy create(@RequestBody Energy energy) {
        return energyService.save(energy);
    }
}
