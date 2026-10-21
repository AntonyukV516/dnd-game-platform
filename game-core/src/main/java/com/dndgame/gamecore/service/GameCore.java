package com.dndgame.gamecore.service;

import com.dndgame.gamecore.dto.ActionRequestDto;
import com.dndgame.gamecore.dto.ActionResponseDto;
import com.dndgame.gamecore.mapper.ActionMapper;
import com.dndgame.gamecore.model.Action;
import com.dndgame.gamecore.model.CharacterClass;
import com.dndgame.gamecore.model.Location;
import com.dndgame.gamecore.model.Origin;
import com.dndgame.gamecore.repository.PlayerStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameCore {
    private final ContentLoader contentLoader;
    private final ActionMapper actionMapper;

    private final PlayerStore playerStore;

    public ActionResponseDto processAction(ActionRequestDto request) {
        var player = playerStore.getOrCreate(request.getPlayerId());
        var location = contentLoader.loadLocation(player.getCurrentLocationId());

        if (request.getActionId() == null || request.getActionId().isBlank()) {
            return buildResponse(location);
        }

        Action action = location.getActions().stream()
                .filter(a -> request.getActionId().equals(a.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Неизвестное действие: " + request.getActionId()));
        player.setCurrentLocationId(action.getNextLocationId());

        if (action.getEffects() != null) {
            if (action.getEffects().containsKey("set_class")) {
                player.setCharacterClass(CharacterClass.valueOf(
                        (String) action.getEffects().get("set_class")));
            }
            if (action.getEffects().containsKey("set_origin")) {
                player.setOrigin(Origin.valueOf(
                        (String) action.getEffects().get("set_origin")));
            }
        }
        var nextLocation = contentLoader.loadLocation(action.getNextLocationId());
        return buildResponse(nextLocation);
    }

    private ActionResponseDto buildResponse(Location location) {
        return ActionResponseDto.builder()
                .description(contentLoader.loadText(location.getDescriptionFile()))
                .actions(location.getActions().stream()
                        .map(actionMapper::toDto)
                        .toList())
                .build();
    }
}