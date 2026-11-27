package com.dndgame.gamecore.repository;

import com.dndgame.gamecore.model.Player;

public interface PlayerRepository {
    Player getOrCreate(String playerId);

    Player get(String playerId);
}