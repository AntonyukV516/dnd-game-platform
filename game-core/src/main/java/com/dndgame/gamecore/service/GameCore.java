package com.dndgame.gamecore.service;

import com.dndgame.gamecore.dto.ActionRequestDto;
import com.dndgame.gamecore.dto.ActionResponseDto;
import com.dndgame.gamecore.model.*;
import com.dndgame.gamecore.repository.PlayerStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameCore {
    private final LocationService locationService;
    private final PlayerStore playerStore;

    public ActionResponseDto processAction(ActionRequestDto request) {
        var player = playerStore.getOrCreate(request.getPlayerId());
        var location = locationService.loadLocation(player.getCurrentLocationId());

        if (request.getActionId() == null || request.getActionId().isBlank()) {
            return locationService.buildResponse(location);
        }

        Action action = locationService.findAction(location, request.getActionId());
        player.setCurrentLocationId(action.getNextLocationId());
        applyEffects(player, action);

        var nextLocation = locationService.loadLocation(action.getNextLocationId());
        return locationService.buildResponse(nextLocation);
    }

    private void applyEffects(Player player, Action action) {
        if (action.getEffects() == null) return;

        if (action.getEffects().containsKey("set_class")) {
            player.setCharacterClass(CharacterClass.valueOf(
                    (String) action.getEffects().get("set_class")));
        }

        if (action.getEffects().containsKey("set_origin")) {
            player.setOrigin(Origin.valueOf(
                    (String) action.getEffects().get("set_origin")));
        }

        if (action.getEffects().containsKey("set_race")) {
            player.setRace(Race.valueOf((String) action.getEffects().get("set_race")));
        }
    }
}