package com.andrewsdosreis.rockpaperscissors.config;

import java.util.Random;

import com.andrewsdosreis.rockpaperscissors.data.RoundDataSource;
import com.andrewsdosreis.rockpaperscissors.data.TotalGamesPlayedDataSource;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;
import com.andrewsdosreis.rockpaperscissors.repository.TotalGamesPlayedRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean(name = "roundRepository")
    public RoundRepository roundRepository() {
        return new RoundDataSource();
    }

    @Bean(name = "totalGamesPlayedRepository")
    public TotalGamesPlayedRepository totalGamesPlayedRepository() {
        return new TotalGamesPlayedDataSource();
    }
}
