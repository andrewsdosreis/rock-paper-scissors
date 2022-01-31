package com.andrewsdosreis.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.andrewsdosreis.rockpaperscissors.model.Session;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {

    private SessionService sessionService;

    @BeforeEach
    public void setUp() {
        sessionService = new SessionService();
    }

    @Test
    void test_createNewSession_shouldCreateANewSession() {
        var actual = sessionService.createNewSession();
        assertEquals(actual.getClass(), Session.class);
        assertFalse(actual.getKey().isEmpty());
    }
    
}
