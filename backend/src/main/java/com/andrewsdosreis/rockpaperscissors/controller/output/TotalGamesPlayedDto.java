package com.andrewsdosreis.rockpaperscissors.controller.output;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TotalGamesPlayedDto {
    
    private Integer totalRoundsPlayed;
    private Integer totalWinsForPlayerOne;
    private Integer totalWinsForPlayerTwo;
    private Integer totalDraws;

    public TotalGamesPlayedDto() {
    }

    public TotalGamesPlayedDto(Integer totalRoundsPlayed, Integer totalWinsForPlayerOne, Integer totalWinsForPlayerTwo, Integer totalDraws) {
        this.totalRoundsPlayed = totalRoundsPlayed;
        this.totalWinsForPlayerOne = totalWinsForPlayerOne;
        this.totalWinsForPlayerTwo = totalWinsForPlayerTwo;
        this.totalDraws = totalDraws;
    }

    public Integer getTotalRoundsPlayed() {
        return this.totalRoundsPlayed;
    }

    public void setTotalRoundsPlayed(Integer totalRoundsPlayed) {
        this.totalRoundsPlayed = totalRoundsPlayed;
    }

    public Integer getTotalWinsForPlayerOne() {
        return this.totalWinsForPlayerOne;
    }

    public void setTotalWinsForPlayerOne(Integer totalWinsForPlayerOne) {
        this.totalWinsForPlayerOne = totalWinsForPlayerOne;
    }

    public Integer getTotalWinsForPlayerTwo() {
        return this.totalWinsForPlayerTwo;
    }

    public void setTotalWinsForPlayerTwo(Integer totalWinsForPlayerTwo) {
        this.totalWinsForPlayerTwo = totalWinsForPlayerTwo;
    }

    public Integer getTotalDraws() {
        return this.totalDraws;
    }

    public void setTotalDraws(Integer totalDraws) {
        this.totalDraws = totalDraws;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
