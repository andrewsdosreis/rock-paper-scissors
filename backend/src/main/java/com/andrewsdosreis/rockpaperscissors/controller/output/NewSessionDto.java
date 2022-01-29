package com.andrewsdosreis.rockpaperscissors.controller.output;

public class NewSessionDto {

    private String key;

    public NewSessionDto() {
    }

    public NewSessionDto(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
