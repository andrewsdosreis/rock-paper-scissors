package com.andrewsdosreis.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.andrewsdosreis.rockpaperscissors.model.Session;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class SessionServiceTest {

    private SessionService sessionService;

    @BeforeAll
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
