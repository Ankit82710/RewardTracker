package com.example.demo.services;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;

import java.time.Month;
import java.util.*;

@Service
public class TransactionService {

    private final RewardService rewardService;

    public TransactionService(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    public Map<String, Integer> calculateMonthlyPoints(List<Transaction> transactions) {
        Map<String, Integer> monthlyPoints = new HashMap<>();

        // Group by customer and month, and then calculate points
        transactions.forEach(transaction -> {
            String key = transaction.getCustomerId() + "-" + transaction.getTransactionDate().getMonth();
            int points = rewardService.calculateRewardPoints(transaction.getAmountSpent());
            monthlyPoints.merge(key, points, Integer::sum); // Add points to the existing value
        });

        return monthlyPoints;
    }

    public int calculateTotalPoints(List<Transaction> transactions) {
        return transactions.stream()
                .mapToInt(transaction -> rewardService.calculateRewardPoints(transaction.getAmountSpent()))
                .sum();
    }
}
