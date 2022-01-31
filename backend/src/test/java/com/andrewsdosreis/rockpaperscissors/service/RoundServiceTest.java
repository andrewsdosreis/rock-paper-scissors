package com.andrewsdosreis.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.andrewsdosreis.rockpaperscissors.data.RoundDataSource;
import com.andrewsdosreis.rockpaperscissors.exception.CouldNotCheckResultException;
import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;
import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.model.RoundPlayed;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class RoundServiceTest {

    Random random;
    RoundService roundService;

    @BeforeAll
    void setUp() {
        RoundRepository roundRepository = new RoundDataSource();
        random = Mockito.mock(Random.class);
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

        when(random.nextInt(3)).thenReturn(0);

        var expectedCounter = roundService.listAllRoundsFromSessionKey(key).size() + 1;
        var expected = new RoundPlayed(RockPaperScissorsEnum.ROCK.toString(), RockPaperScissorsEnum.ROCK.toString(),
                ResultEnum.DRAW.label, expectedCounter);

        var actual = roundService.playOneRound(key);
        var actualCounter = roundService.listAllRoundsFromSessionKey(key).size();

        assertEquals(expected, actual);
        assertEquals(expectedCounter, actualCounter);
    }

    @Test
    void test_playOneRound_shouldPlayOneRoundAndChoosePaper() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.nextInt(3)).thenReturn(1);

        var expectedCounter = roundService.listAllRoundsFromSessionKey(key).size() + 1;
        var expected = new RoundPlayed(RockPaperScissorsEnum.PAPER.toString(), RockPaperScissorsEnum.ROCK.toString(),
                ResultEnum.PLAYER_ONE_WINS.label, expectedCounter);

        var actual = roundService.playOneRound(key);
        var actualCounter = roundService.listAllRoundsFromSessionKey(key).size();

        assertEquals(expected, actual);
        assertEquals(expectedCounter, actualCounter);
    }

    @Test
    void test_playOneRound_shouldPlayOneRoundAndChooseScissors() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.nextInt(3)).thenReturn(2);

        var expectedCounter = roundService.listAllRoundsFromSessionKey(key).size() + 1;
        var expected = new RoundPlayed(RockPaperScissorsEnum.SCISSORS.toString(), RockPaperScissorsEnum.ROCK.toString(),
                ResultEnum.PLAYER_TWO_WINS.label, expectedCounter);

        var actual = roundService.playOneRound(key);
        var actualCounter = roundService.listAllRoundsFromSessionKey(key).size();

        assertEquals(expected, actual);
        assertEquals(expectedCounter, actualCounter);
    }

    @Test
    void test_playOneRound_shouldNotCheckTheResult() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.nextInt(3)).thenReturn(4);

        assertThrows(CouldNotCheckResultException.class, () -> {
            roundService.playOneRound(key);
        });
    }

    @Test
    void test_restart_shouldRemoveFromKey() {
        String key = "OwkZLGZFJQRjBdzd19wCF3yS9kd22h";

        when(random.nextInt(3)).thenReturn(0);

        List<Round> expected = new ArrayList<>();

        roundService.playOneRound(key);
        var countBeforeRestart = roundService.listAllRoundsFromSessionKey(key).size();

        roundService.restart(key);
        var actual = roundService.listAllRoundsFromSessionKey(key);

        assertTrue(countBeforeRestart > 0);
        assertEquals(expected, actual);
    }

}
