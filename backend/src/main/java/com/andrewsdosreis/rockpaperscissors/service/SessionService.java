package com.andrewsdosreis.rockpaperscissors.service;

import com.andrewsdosreis.rockpaperscissors.model.Session;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    public Session createNewSession() {
        LOGGER.info("Creating a new Session key");
        String key = generateKey();
        LOGGER.info("Session with key {} was created", key);
        return new Session(key);
    }

    private String generateKey() {
        int count = 30;
        Boolean letters = Boolean.TRUE;
        Boolean numbers = Boolean.TRUE;
        return RandomStringUtils.random(count, letters, numbers);
    }
}
