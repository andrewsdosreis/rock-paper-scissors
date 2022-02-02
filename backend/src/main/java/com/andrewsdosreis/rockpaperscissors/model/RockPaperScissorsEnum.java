package com.andrewsdosreis.rockpaperscissors.model;

public enum RockPaperScissorsEnum {
    
    ROCK(0), PAPER(1), SCISSORS(2);

    public final Integer value;

    private RockPaperScissorsEnum(Integer value) {
        this.value = value;
    }
 
    public static RockPaperScissorsEnum valueOf(Integer value) {
        for (RockPaperScissorsEnum e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }

    public static String toString(RockPaperScissorsEnum rockPaperScissorsEnum) {
        if (rockPaperScissorsEnum == null)
            return "";
        else
            return rockPaperScissorsEnum.toString();
    }
}
