package com.dndgame.gamecore.controller;

import com.dndgame.gamecore.dto.ActionRequestDto;
import com.dndgame.gamecore.dto.ActionResponseDto;
import com.dndgame.gamecore.service.GameCore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/action")
@RequiredArgsConstructor
public class GameController {
    private final GameCore gameCore;

    @PostMapping
    public ActionResponseDto processAction(@RequestBody ActionRequestDto request) {
        return gameCore.processAction(request);
    }

}