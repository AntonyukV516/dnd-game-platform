package com.dndgame.gamecore.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DiceRoller {
    private final Random random = new Random();

    public int rollD20() {
        return random.nextInt(20) + 1;
    }

    public int roll(int sides) {
        return random.nextInt(sides) + 1;
    }

    public int multiRoll(int diceCount, int sides) {
        int sum = 0;
        for (int i = 0; i < diceCount; i++) {
            sum += roll(sides);
        }
        return sum;
    }
}
