package com.plataformaenergia.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformaenergia.backend.model.Energy;
import com.plataformaenergia.backend.repository.EnergyRepository;

import java.util.List;

@Service
public class EnergyService {

    @Autowired
    private EnergyRepository repo;

    public List<Energy> getAll() {
        return repo.findAll();
    }

    public Energy save(Energy e) {
        return repo.save(e);
    }
}
