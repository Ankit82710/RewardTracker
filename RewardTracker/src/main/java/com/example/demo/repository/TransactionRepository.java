package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Transaction;

/**
 * Repository for Transaction entity.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // You can add custom queries if needed
}


