package com.plataformaenergia.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformaenergia.backend.model.Transaction;
import com.plataformaenergia.backend.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    public List<Transaction> getAll() {
        return repo.findAll();
    }

    public Transaction save(Transaction tx) {
        return repo.save(tx);
    }
}
