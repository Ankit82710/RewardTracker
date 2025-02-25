package com.example.demo.services;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RewardService {

    public int calculateRewardPoints(BigDecimal amountSpent) {
        int points = 0;
        BigDecimal over100 = amountSpent.subtract(BigDecimal.valueOf(100));
        if (over100.compareTo(BigDecimal.ZERO) > 0) {
            points += over100.intValue() * 2;  // 2 points for every dollar spent above $100
            amountSpent = BigDecimal.valueOf(100);  // Reduce the amount to $100
        }

        BigDecimal between50And100 = amountSpent.subtract(BigDecimal.valueOf(50));
        if (between50And100.compareTo(BigDecimal.ZERO) > 0) {
            points += between50And100.intValue();  // 1 point for every dollar between $50-$100
        }

        return points;
    }
}
