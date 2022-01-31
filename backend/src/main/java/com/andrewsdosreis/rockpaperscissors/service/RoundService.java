package com.andrewsdosreis.rockpaperscissors.service;

import java.util.List;
import java.util.Random;

import com.andrewsdosreis.rockpaperscissors.exception.CouldNotCheckResultException;
import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;
import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.model.RoundPlayed;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoundService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoundService.class);

    private Random random;
    private RoundRepository roundRepository;

    public RoundService(RoundRepository roundRepository, Random random) {
        this.roundRepository = roundRepository;
        this.random = random;
    }

    public List<Round> listAllRoundsFromSessionKey(String key) {
        return roundRepository.find(key);
    }

    public RoundPlayed playOneRound(String key) {
        RockPaperScissorsEnum playerOne = generatePlayerOneChoice();
        RockPaperScissorsEnum playerTwo = generatePlayerTwoChoice();
        ResultEnum result = checkResult(playerOne, playerTwo);

        Round round = new Round(playerOne.toString(), playerTwo.toString(), result.label);
        roundRepository.save(key, round);

        return new RoundPlayed(RockPaperScissorsEnum.toString(playerOne), RockPaperScissorsEnum.toString(playerTwo), result, roundRepository.count(key));
    }

    public void restart(String key) {
        roundRepository.delete(key);
    }

    private ResultEnum checkResult(RockPaperScissorsEnum playerOne, RockPaperScissorsEnum playerTwo) {
        ResultEnum result = null;

        if (playerTwo.equals(playerOne))
            result = ResultEnum.DRAW;
        else if (RockPaperScissorsEnum.PAPER.equals(playerOne))
            result = ResultEnum.PLAYER_ONE_WINS;
        else if (RockPaperScissorsEnum.SCISSORS.equals(playerOne))
            result = ResultEnum.PLAYER_TWO_WINS;
        else
            throw new CouldNotCheckResultException(RockPaperScissorsEnum.toString(playerOne), RockPaperScissorsEnum.toString(playerTwo));

        LOGGER.info("Player One choose -> {} | Player Two choose -> {} | Result -> {}", playerOne, playerTwo, result.label);
        return result;
    }

    private RockPaperScissorsEnum generatePlayerOneChoice() {
        Integer randomPlay = random.nextInt(3);
        return RockPaperScissorsEnum.valueOf(randomPlay);
    }

    private RockPaperScissorsEnum generatePlayerTwoChoice() {
        return RockPaperScissorsEnum.ROCK;
    }
}
