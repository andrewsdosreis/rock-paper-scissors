package com.andrewsdosreis.rockpaperscissors.data;

import com.andrewsdosreis.rockpaperscissors.model.TotalGamesPlayed;
import com.andrewsdosreis.rockpaperscissors.repository.TotalGamesPlayedRepository;

public class TotalGamesPlayedDataSource implements TotalGamesPlayedRepository {
    
    static TotalGamesPlayedDataSource instance = null;
    private TotalGamesPlayed data = new TotalGamesPlayed();

    private TotalGamesPlayedDataSource() {
    }

    public static TotalGamesPlayedDataSource getInstance() {
        if (instance == null) {
            instance = new TotalGamesPlayedDataSource();
        }
        return instance;
    }

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
