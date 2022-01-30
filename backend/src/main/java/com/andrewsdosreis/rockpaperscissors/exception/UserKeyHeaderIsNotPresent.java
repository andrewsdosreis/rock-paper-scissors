package com.andrewsdosreis.rockpaperscissors.exception;

public class UserKeyHeaderIsNotPresent extends RuntimeException {

    public UserKeyHeaderIsNotPresent() {
        super("Header USER-KEY is not present");
    }
}
