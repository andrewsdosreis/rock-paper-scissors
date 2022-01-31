package com.andrewsdosreis.rockpaperscissors.model;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RoundPlayed {
    
    private String playerOne;
    private String playerTwo;
    private ResultEnum result;
    private Integer rounds;
    
    public RoundPlayed() {
    }

    public RoundPlayed(String playerOne, String playerTwo, ResultEnum result, Integer rounds) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.result = result;
        this.rounds = rounds;
    }

    public String getPlayerOne() {
        return this.playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return this.playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public ResultEnum getResult() {
        return this.result;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    public Integer getRounds() {
        return this.rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoundPlayed)) {
            return false;
        }
        RoundPlayed roundPlayedDto = (RoundPlayed) o;
        return Objects.equals(playerOne, roundPlayedDto.playerOne) && Objects.equals(playerTwo, roundPlayedDto.playerTwo) && Objects.equals(result, roundPlayedDto.result) && Objects.equals(rounds, roundPlayedDto.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerOne, playerTwo, result, rounds);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}