package com.andrewsdosreis.rockpaperscissors.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected <T> ResponseEntity<T> ok(T body) {
        this.logger.info("Success (200): {}", body);
        return ResponseEntity.ok(body);
    }
}
