package com.dndgame.gamecore.service;

import com.dndgame.gamecore.dto.ActionResponseDto;
import com.dndgame.gamecore.mapper.ActionMapper;
import com.dndgame.gamecore.model.Action;
import com.dndgame.gamecore.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final ContentLoader contentLoader;
    private final ActionMapper actionMapper;

    public Location loadLocation(String locationId) {
        return contentLoader.loadLocation(locationId);
    }

    public Action findAction(Location location, String actionId) {
        return location.getActions().stream()
                .filter(a -> actionId.equals(a.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Неизвестное действие: " + actionId));
    }

    public ActionResponseDto buildResponse(Location location) {
        return ActionResponseDto.builder()
                .description(contentLoader.loadText(location.getDescriptionFile()))
                .actions(location.getActions().stream()
                        .map(actionMapper::toDto)
                        .toList())
                .build();
    }
}
