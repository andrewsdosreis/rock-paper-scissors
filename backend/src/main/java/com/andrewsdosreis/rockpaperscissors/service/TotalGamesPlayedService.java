package com.andrewsdosreis.rockpaperscissors.service;

import com.andrewsdosreis.rockpaperscissors.model.ResultEnum;
import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.repository.TotalGamesPlayedRepository;

import org.springframework.stereotype.Service;

@Service
public class TotalGamesPlayedService {
    
    private TotalGamesPlayedRepository totalGamesPlayedRepository;

    public TotalGamesPlayedService(TotalGamesPlayedRepository totalGamesPlayedRepository) {
        this.totalGamesPlayedRepository = totalGamesPlayedRepository;
    }

    public TotalGamesPlayed find() {
        return totalGamesPlayedRepository.find();
    }

    public TotalGamesPlayed increaseTotalGamesPlayed(ResultEnum result) {
        if (ResultEnum.DRAW.equals(result))
            totalGamesPlayedRepository.increaseDraw();
        else if (ResultEnum.PLAYER_ONE_WINS.equals(result))
            totalGamesPlayedRepository.increasePlayerOneWins();
        else if (ResultEnum.PLAYER_TWO_WINS.equals(result))
            totalGamesPlayedRepository.increasePlayerTwoWins();

        return find();
    }
}
