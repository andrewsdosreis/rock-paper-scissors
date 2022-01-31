package com.andrewsdosreis.rockpaperscissors.data;

import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.repository.TotalGamesPlayedRepository;

public class TotalGamesPlayedDataSource implements TotalGamesPlayedRepository {
    
    private TotalGamesPlayed data = new TotalGamesPlayed();

    @Override
    public synchronized TotalGamesPlayed find() {
        return data;
    }

    @Override
    public synchronized void increaseDraw() {
        data.increaseTotalRoundsPlayed();
        data.increaseTotalDraws();
    }

    @Override
    public synchronized void increasePlayerOneWins() {
        data.increaseTotalRoundsPlayed();
        data.increaseTotalWinsForPlayerOne();
    }

    @Override
    public synchronized void increasePlayerTwoWins() {
        data.increaseTotalRoundsPlayed();
        data.increaseTotalWinsForPlayerTwo();
    }
}
