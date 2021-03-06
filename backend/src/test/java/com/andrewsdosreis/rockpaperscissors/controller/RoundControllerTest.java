package com.andrewsdosreis.rockpaperscissors.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.andrewsdosreis.rockpaperscissors.exception.handler.GlobalExceptionHandler;
import com.andrewsdosreis.rockpaperscissors.interceptor.RequestInterceptor;
import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;
import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.service.RoundService;
import com.andrewsdosreis.rockpaperscissors.service.TotalGamesPlayedService;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class RoundControllerTest {

    MockMvc mockmvc;
    
    @InjectMocks
    RoundController roundController;
    
    @InjectMocks
    GlobalExceptionHandler handler;

    @InjectMocks
    RequestInterceptor interceptor;
    
    @Mock
    RoundService roundService;
    
    @Mock
    TotalGamesPlayedService totalGamesPlayedService;

    @BeforeEach
    void setUp() {
        mockmvc = MockMvcBuilders.standaloneSetup(roundController)
                .setControllerAdvice(handler)
                .addInterceptors(interceptor)
                .build();
    }

    @Test
    void test_listRoundsFromSession_shouldReturn() throws Exception {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";
        List<Round> rounds = new ArrayList<>();
        when(roundService.listAllRoundsFromSessionKey(key)).thenReturn(rounds);
        mockmvc.perform(get("/v1/rounds").header(RoundController.SESSION_KEY, key))
                .andExpect(status().isOk());
    }

    @Test
    void test_listRoundsFromSession_headerIsMissing() throws Exception {
        mockmvc.perform(get("/v1/rounds")).andExpect(status().isUnauthorized());
    }

    @Test
    void test_listRoundsFromSession_headerIsEmpty() throws Exception {
        mockmvc.perform(get("/v1/rounds").header(RoundController.SESSION_KEY, Strings.EMPTY)).andExpect(status().isUnauthorized());
    }

    @Test
    void test_playOneRound_shouldPlay() throws Exception {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";
        Round roundPlayed = new Round(RockPaperScissorsEnum.PAPER.toString(),
                                      RockPaperScissorsEnum.ROCK.toString(),
                                      ResultEnum.PLAYER_ONE_WINS.label);

        TotalGamesPlayed totalGamesPlayed = new TotalGamesPlayed();

        when(roundService.playOneRound(key)).thenReturn(roundPlayed);
        when(totalGamesPlayedService.increaseTotalGamesPlayed(any())).thenReturn(totalGamesPlayed);

        mockmvc.perform(post("/v1/rounds").header(RoundController.SESSION_KEY, key))
                .andExpect(status().isOk())
                .andExpect(jsonPath("playerOne").value(roundPlayed.getPlayerOne()))
                .andExpect(jsonPath("playerTwo").value(roundPlayed.getPlayerTwo()))
                .andExpect(jsonPath("result").value(roundPlayed.getResult().toString()));
    }

    @Test
    void test_playOneRound_headerIsMissing() throws Exception {
        mockmvc.perform(post("/v1/rounds")).andExpect(status().isUnauthorized());
    }

    @Test
    void test_restartRoundsFromSession_shouldRestart() throws Exception {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";
        mockmvc.perform(delete("/v1/rounds").header(RoundController.SESSION_KEY, key))
               .andExpect(status().isOk());
    }
    
    @Test
    void test_restartRoundsFromSession_headerIsMissing() throws Exception {
        mockmvc.perform(delete("/v1/rounds")).andExpect(status().isUnauthorized());
    }
}
