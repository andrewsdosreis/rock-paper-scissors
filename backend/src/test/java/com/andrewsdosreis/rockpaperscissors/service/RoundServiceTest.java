package com.andrewsdosreis.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.andrewsdosreis.rockpaperscissors.data.RoundDataSource;
import com.andrewsdosreis.rockpaperscissors.exception.CouldNotCheckResultException;
import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;
import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class RoundServiceTest {

    RoundService roundService;
    RockPaperScissorsRandom random;

    @BeforeAll
    void setUp() {
        RoundRepository roundRepository = new RoundDataSource();
        random = Mockito.mock(RockPaperScissorsRandom.class);
        roundService = new RoundService(roundRepository, random);
    }

    @Test
    void test_listAllRoundsFromSessionKey_shouldReturnAnEmptyList() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        List<Round> expected = new ArrayList<>();

        roundService.restart(key);
        var actual = roundService.listAllRoundsFromSessionKey(key);

        assertEquals(expected, actual);
    }

    @Test
    void test_playOneRound_shouldPlayOneRoundAndChooseRock() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.generateRandomChoice()).thenReturn(RockPaperScissorsEnum.ROCK);

        var expected = new Round(RockPaperScissorsEnum.ROCK.toString(), RockPaperScissorsEnum.ROCK.toString(), ResultEnum.DRAW.label);
        var actual = roundService.playOneRound(key);

        assertEquals(expected, actual);
    }

    @Test
    void test_playOneRound_shouldPlayOneRoundAndChoosePaper() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.generateRandomChoice()).thenReturn(RockPaperScissorsEnum.PAPER);

        var expected = new Round(RockPaperScissorsEnum.PAPER.toString(), RockPaperScissorsEnum.ROCK.toString(), ResultEnum.PLAYER_ONE_WINS.label);
        var actual = roundService.playOneRound(key);

        assertEquals(expected, actual);
    }

    @Test
    void test_playOneRound_shouldPlayOneRoundAndChooseScissors() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.generateRandomChoice()).thenReturn(RockPaperScissorsEnum.SCISSORS);

        var expected = new Round(RockPaperScissorsEnum.SCISSORS.toString(), RockPaperScissorsEnum.ROCK.toString(), ResultEnum.PLAYER_TWO_WINS.label);
        var actual = roundService.playOneRound(key);

        assertEquals(expected, actual);
    }

    @Test
    void test_playOneRound_shouldNotCheckTheResult() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.generateRandomChoice()).thenReturn(null);

        assertThrows(CouldNotCheckResultException.class, () -> {
            roundService.playOneRound(key);
        });
    }

    @Test
    void test_restart_shouldRemoveFromKey() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.generateRandomChoice()).thenReturn(RockPaperScissorsEnum.ROCK);

        List<Round> expected = new ArrayList<>();

        roundService.playOneRound(key);
        var countBeforeRestart = roundService.listAllRoundsFromSessionKey(key).size();

        roundService.restart(key);
        var actual = roundService.listAllRoundsFromSessionKey(key);

        assertTrue(countBeforeRestart > 0);
        assertEquals(expected, actual);
    }

}
