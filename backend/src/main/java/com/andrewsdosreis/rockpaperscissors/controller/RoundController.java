package com.andrewsdosreis.rockpaperscissors.controller;

import java.util.List;

import com.andrewsdosreis.rockpaperscissors.controller.output.RoundPlayedDto;
import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.service.RoundService;
import com.andrewsdosreis.rockpaperscissors.service.TotalGamesPlayedService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rounds")
public class RoundController extends BaseController {
    
    private RoundService roundService;
    private TotalGamesPlayedService totalGamesPlayedService;

    public RoundController(RoundService gameplayService, TotalGamesPlayedService totalGamesPlayedService) {
        this.roundService = gameplayService;
        this.totalGamesPlayedService = totalGamesPlayedService;
    }

    @GetMapping
    public ResponseEntity<List<Round>> listRoundsFromUser(@RequestHeader(name = USER_KEY) String key) {
        List<Round> rounds = roundService.listAllRoundsFromSessionKey(key);
        return ok(rounds);
    }

    @PostMapping
    public ResponseEntity<RoundPlayedDto> playOneRound(@RequestHeader(name = USER_KEY) String key) {
        RoundPlayedDto roundPlayed = roundService.playOneRound(key);
        totalGamesPlayedService.increaseTotalGamesPlayed(roundPlayed.getResult());
        return ok(roundPlayed);
    }

    @DeleteMapping
    public <T> ResponseEntity<T> restartRoundsFromUser(@RequestHeader(name = USER_KEY) String key) {
        roundService.restart(key);
        return ok();
    }
}
