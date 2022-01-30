package com.andrewsdosreis.rockpaperscissors.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TotalGamesPlayed {
    
    private Integer totalRoundsPlayed;
    private Integer totalWinsForPlayerOne;
    private Integer totalWinsForPlayerTwo;
    private Integer totalDraws;

    public TotalGamesPlayed() {
        this.totalRoundsPlayed = 0;
        this.totalWinsForPlayerOne = 0;
        this.totalWinsForPlayerTwo = 0;
        this.totalDraws = 0;
    }

    public Integer getTotalRoundsPlayed() {
        return this.totalRoundsPlayed;
    }

    public void increaseTotalRoundsPlayed() {
        this.totalRoundsPlayed++;
    }

    public Integer getTotalWinsForPlayerOne() {
        return this.totalWinsForPlayerOne;
    }

    public void increaseTotalWinsForPlayerOne() {
        this.totalWinsForPlayerOne++;
    }

    public Integer getTotalWinsForPlayerTwo() {
        return this.totalWinsForPlayerTwo;
    }

    public void increaseTotalWinsForPlayerTwo() {
        this.totalWinsForPlayerTwo++;
    }

    public Integer getTotalDraws() {
        return this.totalDraws;
    }

    public void increaseTotalDraws() {
        this.totalDraws++;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
