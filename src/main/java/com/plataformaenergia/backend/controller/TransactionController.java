package com.plataformaenergia.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.plataformaenergia.backend.model.Transaction;
import com.plataformaenergia.backend.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction tx) {
        return transactionService.save(tx);
    }
}
