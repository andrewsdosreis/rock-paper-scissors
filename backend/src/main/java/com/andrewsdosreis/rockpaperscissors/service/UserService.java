package com.andrewsdosreis.rockpaperscissors.service;

import com.andrewsdosreis.rockpaperscissors.controller.output.UserDto;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public UserDto createNewUser() {
        String key = generateKey();
        return new UserDto(key);
    }

    private String generateKey() {
        int count = 30;
        Boolean letters = Boolean.TRUE;
        Boolean numbers = Boolean.TRUE;
        return RandomStringUtils.random(count, letters, numbers);
    }
}
