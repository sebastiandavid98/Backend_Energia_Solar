package com.plataformaenergia.backend.service;

import com.plataformaenergia.backend.model.Energy;
import com.plataformaenergia.backend.repository.EnergyRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyService {
    private final EnergyRepository energyRepository;

    public EnergyService(EnergyRepository energyRepository) {
        this.energyRepository = energyRepository;
    }

    public List<Energy> getAllEnergy() {
        return energyRepository.findAll();
    }

    public Optional<Energy> getEnergyById(String id) {
        return energyRepository.findById(id);
    }

    public Energy createEnergy(Energy energy) {
        if (energy.getTimestamp() == null) {
            energy.setTimestamp(LocalDateTime.now());
        }
        return energyRepository.save(energy);
    }

    public void deleteEnergy(String id) {
        energyRepository.deleteById(id);
    }
}
