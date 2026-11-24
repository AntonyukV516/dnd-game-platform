package com.dndgame.gamecore.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DiceRoller {
    private final Random random = new Random();

    public int rollD20() {
        return random.nextInt(20) + 1;
    }

    public int roll(int diceCount, int sides) {
        int sum = 0;
        for (int i = 0; i < diceCount; i++) {
            sum += random.nextInt(sides) + 1;
        }
        return sum;
    }
}
