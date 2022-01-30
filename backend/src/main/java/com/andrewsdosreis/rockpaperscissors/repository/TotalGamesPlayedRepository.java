package com.andrewsdosreis.rockpaperscissors.repository;

import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;

import org.springframework.stereotype.Repository;

@Repository("totalGamesPlayedRepository")
public interface TotalGamesPlayedRepository {

    TotalGamesPlayed find();

    void increaseDraw();

    void increasePlayerOneWins();

    void increasePlayerTwoWins();
    
}
