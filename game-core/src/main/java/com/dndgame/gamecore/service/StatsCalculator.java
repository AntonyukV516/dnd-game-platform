package com.dndgame.gamecore.service;

import com.dndgame.gamecore.model.Player;
import org.springframework.stereotype.Service;

@Service
public class StatsCalculator {

    public void applyStats(Player player) {
        int str = 10, dex = 10, con = 10, intl = 10, wis = 10, cha = 10;

        switch (player.getCharacterClass()) {
            case WARRIOR -> { str = 15; dex = 12; con = 14; intl = 8; wis = 10; cha = 8; }
            case WIZARD -> { str = 8; dex = 12; con = 10; intl = 15; wis = 12; cha = 10; }
            case ROGUE -> { str = 8; dex = 15; con = 12; intl = 10; wis = 12; cha = 10; }
        }

        if (player.getRace() != null) {
            switch (player.getRace()) {
                case HUMAN -> { str++; dex++; con++; intl++; wis++; cha++; }
                case ELF -> { dex += 2; intl++; }
                case DWARF -> con += 2;
                case HALFLING -> { dex++; cha++; }
            }
        }

        if (player.getOrigin() != null) {
            switch (player.getOrigin()) {
                case SOLDIER -> { str++; con++; }
                case NOBLE -> cha += 2;
                case FOLK_HERO -> { str++; con++; }
                case SAGE -> { intl++; wis++; }
                case HERMIT -> { con++; wis++; }
                case ACOLYTE -> { intl++; wis++; }
                case CRIMINAL -> { dex++; cha++; }
                case URCHIN -> { dex++; wis++; }
                case CHARLATAN -> { dex++; cha++; }
            }
        }

        int hitDie = switch (player.getCharacterClass()) {
            case WARRIOR -> 10;
            case WIZARD -> 6;
            case ROGUE -> 8;
        };

        int conMod = (con - 10) / 2;
        int hp = Math.max(1, hitDie + conMod);

        player.setStrength(str);
        player.setDexterity(dex);
        player.setConstitution(con);
        player.setIntelligence(intl);
        player.setWisdom(wis);
        player.setCharisma(cha);

        player.setHp(hp);
        player.setMaxHp(hp);
        player.setLevel(1);
    }
}