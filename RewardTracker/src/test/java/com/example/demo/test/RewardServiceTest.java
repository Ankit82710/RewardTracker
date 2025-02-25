package com.example.demo.test;
import org.junit.jupiter.api.Test;

import com.example.demo.services.RewardService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RewardServiceTest {

    private final RewardService rewardService = new RewardService();

    @Test
    void calculateRewardPoints_Above100() {
        BigDecimal amount = BigDecimal.valueOf(120);
        int points = rewardService.calculateRewardPoints(amount);
        assertEquals(90, points);
    }

    @Test
    void calculateRewardPoints_Between50And100() {
        BigDecimal amount = BigDecimal.valueOf(80);
        int points = rewardService.calculateRewardPoints(amount);
        assertEquals(30, points);
    }

    @Test
    void calculateRewardPoints_LessThan50() {
        BigDecimal amount = BigDecimal.valueOf(40);
        int points = rewardService.calculateRewardPoints(amount);
        assertEquals(0, points);
    }
}

