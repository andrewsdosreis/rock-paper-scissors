package com.andrewsdosreis.rockpaperscissors.controller;

import com.andrewsdosreis.rockpaperscissors.controller.output.TotalGamesPlayedDto;
import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.service.TotalGamesPlayedService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/total-games-played")
public class TotalGamesPlayedController extends BaseController {
    
    private TotalGamesPlayedService totalGamesPlayedService;
    private ObjectMapper objectMapper;

    public TotalGamesPlayedController(TotalGamesPlayedService totalGamesPlayedService, ObjectMapper objectMapper) {
        this.totalGamesPlayedService = totalGamesPlayedService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<TotalGamesPlayedDto> find() {
        TotalGamesPlayed totalGamesPlayed = totalGamesPlayedService.find();
        return ok(objectMapper.convertValue(totalGamesPlayed, TotalGamesPlayedDto.class));
    }
}
