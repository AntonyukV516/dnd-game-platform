package com.dndgame.gamecore.service;

import com.dndgame.gamecore.dto.ActionRequestDto;
import com.dndgame.gamecore.dto.ActionResponseDto;
import com.dndgame.gamecore.mapper.ActionMapper;
import com.dndgame.gamecore.model.Action;
import com.dndgame.gamecore.model.Location;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class GameCore {
    private final ContentLoader contentLoader;
    private final ActionMapper actionMapper;

    private String currentLocationId = "pro-common-01";

    public GameCore(ContentLoader contentLoader, ActionMapper actionMapper) {
        this.contentLoader = contentLoader;
        this.actionMapper = actionMapper;
    }

    public ActionResponseDto processAction(ActionRequestDto request) {
        if (request.getActionId() == null || request.getActionId().isBlank()) {
            return start();
        }

        var location = contentLoader.loadLocation(currentLocationId);
        Action action = location.getActions().stream()
                .filter(a -> request.getActionId().equals(a.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Неизвестное действие: " + request.getActionId()));
        currentLocationId = action.getNextLocationId();
        var nextLocation = contentLoader.loadLocation(action.getNextLocationId());

        return buildResponse(nextLocation);
    }

    private ActionResponseDto start() {
        var location = contentLoader.loadLocation("pro-common-01");
        return buildResponse(location);
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