package com.andrewsdosreis.rockpaperscissors.exception;

public class SessionKeyHeaderIsNotPresent extends RuntimeException {

    public SessionKeyHeaderIsNotPresent() {
        super("Header SESSION-KEY is not present");
    }
}
