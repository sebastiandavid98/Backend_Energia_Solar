package com.plataformaenergia.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.plataformaenergia.backend.model.Transaction;
import com.plataformaenergia.backend.repository.TransactionRepository;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction tx) {
        return repo.save(tx);
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }
}
