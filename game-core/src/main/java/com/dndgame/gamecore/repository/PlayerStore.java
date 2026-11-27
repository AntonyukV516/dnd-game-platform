package com.dndgame.gamecore.repository;

import com.dndgame.gamecore.model.Player;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PlayerStore implements PlayerRepository {
    private final Map<String, Player> players = new ConcurrentHashMap<>();

    @Override
    public Player getOrCreate(String playerId) {
        return players.computeIfAbsent(playerId, id -> {
            Player player = Player.builder()
                    .id(id)
                    .level(0)
                    .hp(0)
                    .currentLocationId("pro-common-01")
                    .build();
            return player;
        });
    }

    @Override
    public Player get(String playerId) {
        return players.get(playerId);
    }
}