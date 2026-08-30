package com.dndgame.gamecore.mapper;

import com.dndgame.gamecore.dto.ActionDto;
import com.dndgame.gamecore.model.Action;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActionMapper {
    ActionDto toDto(Action action);
}