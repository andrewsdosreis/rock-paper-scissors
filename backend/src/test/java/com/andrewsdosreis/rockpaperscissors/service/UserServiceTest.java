package com.andrewsdosreis.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.andrewsdosreis.rockpaperscissors.controller.output.UserDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    void test_createNewUser_shouldCreateANewUser() {
        var actual = userService.createNewUser();
        assertEquals(actual.getClass(), UserDto.class);
        assertFalse(actual.getKey().isEmpty());
    }
    
}
