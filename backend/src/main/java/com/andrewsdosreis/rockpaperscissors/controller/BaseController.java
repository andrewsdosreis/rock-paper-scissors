package com.andrewsdosreis.rockpaperscissors.controller;

import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    
    protected static final String SESSION_KEY = "SESSION-KEY";

    protected <T> ResponseEntity<T> ok() {
        return ResponseEntity.ok().build();
    }

    protected <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.ok(body);
    }
}
