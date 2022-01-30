package com.andrewsdosreis.rockpaperscissors.config;

import com.andrewsdosreis.rockpaperscissors.data.RoundDataSource;
import com.andrewsdosreis.rockpaperscissors.data.TotalGamesPlayedDataSource;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;
import com.andrewsdosreis.rockpaperscissors.repository.TotalGamesPlayedRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean(name = "roundRepository")
    public RoundRepository roundRepository() {
        return RoundDataSource.getInstance();
    }

    @Bean(name = "totalGamesPlayedRepository")
    public TotalGamesPlayedRepository totalGamesPlayedRepository() {
        return TotalGamesPlayedDataSource.getInstance();
    }
}
