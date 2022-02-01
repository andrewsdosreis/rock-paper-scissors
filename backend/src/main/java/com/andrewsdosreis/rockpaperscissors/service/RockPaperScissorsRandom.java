package com.andrewsdosreis.rockpaperscissors.service;

import java.security.SecureRandom;

import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;

import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorsRandom {
    
    private SecureRandom random = new SecureRandom();

    public RockPaperScissorsEnum generateRandomChoice() {
        Integer randomPlay = random.nextInt(3);
        return RockPaperScissorsEnum.valueOf(randomPlay);        
    }
}
