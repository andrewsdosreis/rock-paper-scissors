package com.andrewsdosreis.rockpaperscissors.controller;

import com.andrewsdosreis.rockpaperscissors.service.GameplayService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/play")
public class GameplayController extends BaseController {

    private GameplayService gameplayService;

    public GameplayController(GameplayService gameplayService) {
        this.gameplayService = gameplayService;
    }

    @GetMapping
    public ResponseEntity<String> play() {
        String result = gameplayService.play();
        return ok(result);
    }
}
