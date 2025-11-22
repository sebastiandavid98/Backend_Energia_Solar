package com.plataformaenergia.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.plataformaenergia.backend.model.Energy;

public interface EnergyRepository extends MongoRepository<Energy, String> {

}
