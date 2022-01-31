package com.andrewsdosreis.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.andrewsdosreis.rockpaperscissors.data.TotalGamesPlayedDataSource;
import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.repository.TotalGamesPlayedRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TotalGamesPlayedServiceTest {

    private TotalGamesPlayedService totalGamesPlayedService;
    private TotalGamesPlayed expected = new TotalGamesPlayed();

    @BeforeAll
    void setUp() {
        TotalGamesPlayedRepository totalGamesPlayedRepository = new TotalGamesPlayedDataSource();
        totalGamesPlayedService = new TotalGamesPlayedService(totalGamesPlayedRepository);
    }

    @Test
    void test_find_shouldFindAndReturnEmpty() {
        var actual = totalGamesPlayedService.find();

        assertEquals(expected, actual);
    }

    @Test
    void test_increaseTotalGamesPlayed_shouldIncreaseOneDraw() {
        expected.increaseTotalDraws();
        expected.increaseTotalRoundsPlayed();

        var actual = totalGamesPlayedService.increaseTotalGamesPlayed(ResultEnum.DRAW);

        assertEquals(expected, actual);
    }

    @Test
    void test_increaseTotalGamesPlayed_shouldIncreaseOnePlayerOneWin() {
        expected.increaseTotalWinsForPlayerOne();
        expected.increaseTotalRoundsPlayed();

        var actual = totalGamesPlayedService.increaseTotalGamesPlayed(ResultEnum.PLAYER_ONE_WINS);

        assertEquals(expected, actual);
    }

    @Test
    void test_increaseTotalGamesPlayed_shouldIncreaseOnePlayerTwoWin() {
        expected.increaseTotalWinsForPlayerTwo();
        expected.increaseTotalRoundsPlayed();

        var actual = totalGamesPlayedService.increaseTotalGamesPlayed(ResultEnum.PLAYER_TWO_WINS);

        assertEquals(expected, actual);
    }
}
