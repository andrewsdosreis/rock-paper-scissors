package com.andrewsdosreis.rockpaperscissors.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    
    public String generateNewKey() {
        int count = 30;
        Boolean letters = Boolean.TRUE;
        Boolean numbers = Boolean.TRUE;
        return RandomStringUtils.random(count, letters, numbers);
    }

}
