package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Transaction;
import com.example.demo.services.TransactionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Endpoint to get monthly reward points for each customer
    @PostMapping("/monthly-points")
    public Map<String, Integer> getMonthlyPoints(@RequestBody List<Transaction> transactions) {
        return transactionService.calculateMonthlyPoints(transactions);
    }

    // Endpoint to get total reward points for all customers
    @PostMapping("/total-points")
    public int getTotalPoints(@RequestBody List<Transaction> transactions) {
        return transactionService.calculateTotalPoints(transactions);
    }
}
