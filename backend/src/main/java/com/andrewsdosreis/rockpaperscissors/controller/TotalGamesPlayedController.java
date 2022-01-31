package com.andrewsdosreis.rockpaperscissors.controller;

import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.service.TotalGamesPlayedService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/total-games-played")
public class TotalGamesPlayedController extends BaseController {
    
    private TotalGamesPlayedService totalGamesPlayedService;

    public TotalGamesPlayedController(TotalGamesPlayedService totalGamesPlayedService) {
        this.totalGamesPlayedService = totalGamesPlayedService;
    }

    @GetMapping
    public ResponseEntity<TotalGamesPlayed> find() {
        return ok(totalGamesPlayedService.find());
    }
}
