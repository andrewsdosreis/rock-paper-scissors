package com.andrewsdosreis.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.andrewsdosreis.rockpaperscissors.model.RockPaperScissorsEnum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class RockPaperScissorsRandomTest {

    RockPaperScissorsRandom rockPaperScissorsRandom;

    @BeforeAll
    void setUp() {
        rockPaperScissorsRandom = new RockPaperScissorsRandom();
    }

    @Test
    void test_generateRandomChoice_shouldWork() {
        var actual = rockPaperScissorsRandom.generateRandomChoice();
        assertEquals(RockPaperScissorsEnum.class, actual.getClass());
    }
}
