package com.andrewsdosreis.rockpaperscissors.service;

import com.andrewsdosreis.rockpaperscissors.model.Session;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    
    public Session createNewSession() {
        String key = generateKey();
        return new Session(key);
    }

    private String generateKey() {
        int count = 30;
        Boolean letters = Boolean.TRUE;
        Boolean numbers = Boolean.TRUE;
        return RandomStringUtils.random(count, letters, numbers);
    }
}
