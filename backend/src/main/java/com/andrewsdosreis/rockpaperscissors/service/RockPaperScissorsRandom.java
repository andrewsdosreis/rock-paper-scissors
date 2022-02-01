package com.andrewsdosreis.rockpaperscissors.service;

import java.util.Random;

import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;

import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorsRandom {
    
    private Random random = new Random();

    public RockPaperScissorsEnum generateRandomChoice() {
        Integer randomPlay = random.nextInt(3);
        return RockPaperScissorsEnum.valueOf(randomPlay);        
    }
}
