package com.andrewsdosreis.rockpaperscissors.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.andrewsdosreis.rockpaperscissors.controller.output.TotalGamesPlayedDto;
import com.andrewsdosreis.rockpaperscissors.exception.handler.GlobalExceptionHandler;
import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.service.TotalGamesPlayedService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class TotalGamesPlayedControllerTest {
    
    MockMvc mockmvc;

    @InjectMocks
    TotalGamesPlayedController totalGamesPlayedController;

    @InjectMocks
    GlobalExceptionHandler handler;

    @Mock
    TotalGamesPlayedService totalGamesPlayedService;

    @Mock
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockmvc = MockMvcBuilders.standaloneSetup(totalGamesPlayedController)
                                 .setControllerAdvice(handler)
                                 .build();
    }

    @Test
    void test_find_shouldReturn() throws Exception {
        TotalGamesPlayed totalGamesPlayed = new TotalGamesPlayed();
        TotalGamesPlayedDto totalGamesPlayedDto = new TotalGamesPlayedDto(0, 0, 0, 0);

        when(totalGamesPlayedService.find()).thenReturn(totalGamesPlayed);
        when(objectMapper.convertValue(totalGamesPlayed, TotalGamesPlayedDto.class)).thenReturn(totalGamesPlayedDto);

        mockmvc.perform(get("/v1/total-games-played"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("totalRoundsPlayed").value(totalGamesPlayed.getTotalRoundsPlayed()))
               .andExpect(jsonPath("totalWinsForPlayerOne").value(totalGamesPlayed.getTotalDraws()))
               .andExpect(jsonPath("totalWinsForPlayerTwo").value(totalGamesPlayed.getTotalWinsForPlayerOne()))
               .andExpect(jsonPath("totalDraws").value(totalGamesPlayed.getTotalWinsForPlayerTwo()));
    }
}
