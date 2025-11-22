package com.plataformaenergia.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.plataformaenergia.backend.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
