package com.andrewsdosreis.rockpaperscissors.model;

public enum ResultEnum {
    
    DRAW("DRAW"), PLAYER_ONE_WINS("PLAYER ONE WINS"), PLAYER_TWO_WINS("PLAYER TWO WINS");

    public final String label;

    private ResultEnum(String label) {
        this.label = label;
    }

    public static ResultEnum valueOfLabel(String label) {
        for (var resultEnum : values()) {
            if (resultEnum.label.equals(label)) {
                return resultEnum;
            }
        }
        return null;
    }    
}
