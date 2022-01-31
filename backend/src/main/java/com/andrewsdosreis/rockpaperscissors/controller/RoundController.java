package com.andrewsdosreis.rockpaperscissors.controller;

import java.util.List;

import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.model.RoundPlayed;
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
    public ResponseEntity<List<Round>> listRoundsFromSession(@RequestHeader(name = SESSION_KEY) String key) {
        List<Round> rounds = roundService.listAllRoundsFromSessionKey(key);
        return ok(rounds);
    }

    @PostMapping
    public ResponseEntity<RoundPlayed> playOneRound(@RequestHeader(name = SESSION_KEY) String key) {
        RoundPlayed roundPlayed = roundService.playOneRound(key);
        totalGamesPlayedService.increaseTotalGamesPlayed(ResultEnum.valueOfLabel(roundPlayed.getResult()));
        return ok(roundPlayed);
    }

    @DeleteMapping
    public <T> ResponseEntity<T> restartRoundsFromSession(@RequestHeader(name = SESSION_KEY) String key) {
        roundService.restart(key);
        return ok();
    }
}
