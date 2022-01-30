package com.andrewsdosreis.rockpaperscissors.exception;

public class CouldNotCheckResultException extends RuntimeException {

    public CouldNotCheckResultException(String playerOne, String playerTwo) {
        super(String.format(
                "Could not check the result from this Round! Player One choose '%s' and Player Two choose '%s'",
                playerOne, playerTwo));
    }
}
