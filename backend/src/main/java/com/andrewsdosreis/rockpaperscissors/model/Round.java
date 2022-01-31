package com.andrewsdosreis.rockpaperscissors.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Round {
    
    private String playerOne;
    private String playerTwo;
    private String result;

    public Round() {
    }

    public Round(String playerOne, String playerTwo, String result) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.result = result;
    }

    public String getPlayerOne() {
        return this.playerOne;
    }

    public String getPlayerTwo() {
        return this.playerTwo;
    }

    public String getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
