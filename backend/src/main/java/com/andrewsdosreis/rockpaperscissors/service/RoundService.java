package com.andrewsdosreis.rockpaperscissors.service;

import java.util.List;

import com.andrewsdosreis.rockpaperscissors.exception.CouldNotCheckResultException;
import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;
import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoundService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoundService.class);

    private RockPaperScissorsRandom rockPaperScissorsRandom;
    private RoundRepository roundRepository;

    public RoundService(RoundRepository roundRepository, RockPaperScissorsRandom rockPaperScissorsRandom) {
        this.roundRepository = roundRepository;
        this.rockPaperScissorsRandom = rockPaperScissorsRandom;
    }

    public List<Round> listAllRoundsFromSessionKey(String key) {
        LOGGER.info("Listing all rounds from Session with key {}", key);
        return roundRepository.find(key);
    }

    public Round playOneRound(String key) {
        LOGGER.info("Starting to play");
        RockPaperScissorsEnum playerOne = generatePlayerOneChoice();
        RockPaperScissorsEnum playerTwo = generatePlayerTwoChoice();
        ResultEnum result = checkResult(playerOne, playerTwo);
        
        Round roundPlayed = new Round(playerOne.toString(), playerTwo.toString(), result.label);
        roundRepository.save(key, roundPlayed);
        LOGGER.info("Round was played -> {}", roundPlayed);

        return roundPlayed;
    }

    public void restart(String key) {
        LOGGER.info("Restarting all rounds from Session key {}", key);
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

        return result;
    }

    private RockPaperScissorsEnum generatePlayerOneChoice() {
        return rockPaperScissorsRandom.generateRandomChoice();
    }

    private RockPaperScissorsEnum generatePlayerTwoChoice() {
        return RockPaperScissorsEnum.ROCK;
    }
}
