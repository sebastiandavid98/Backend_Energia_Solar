package com.plataformaenergia.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.plataformaenergia.backend.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    // Para login
    Optional<User> findByEmailAndPassword(String email, String password);
}
