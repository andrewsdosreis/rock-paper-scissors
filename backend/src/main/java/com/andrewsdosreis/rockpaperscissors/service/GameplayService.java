package com.andrewsdosreis.rockpaperscissors.service;

import java.util.Random;

import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameplayService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Random random = new Random();

    public String play() {
        RockPaperScissorsEnum playerOne = generatePlayerOneChoice();
        RockPaperScissorsEnum playerTwo = generatePlayerTwoChoice();

        return checkResult(playerOne, playerTwo);
    }

    private String checkResult(RockPaperScissorsEnum playerOne, RockPaperScissorsEnum playerTwo) {
        String result;

        if (playerOne.equals(playerTwo))
            result = "DRAW";

        else if (playerOne.equals(RockPaperScissorsEnum.PAPER))
            result = "1 WINS";

        else if (playerOne.equals(RockPaperScissorsEnum.SCISSORS))
            result = "2 WINS";
        else
            throw new RuntimeException();

        logger.info("Player 1 {} | Player 2 {} | Result {}", playerOne, playerTwo, result);

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
