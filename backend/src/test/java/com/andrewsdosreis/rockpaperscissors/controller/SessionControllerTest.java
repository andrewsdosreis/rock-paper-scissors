package com.andrewsdosreis.rockpaperscissors.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.andrewsdosreis.rockpaperscissors.exception.handler.GlobalExceptionHandler;
import com.andrewsdosreis.rockpaperscissors.model.Session;
import com.andrewsdosreis.rockpaperscissors.service.SessionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class SessionControllerTest {

    MockMvc mockmvc;
    
    @InjectMocks
    SessionController sessionController;
    
    @InjectMocks
    GlobalExceptionHandler handler;
    
    @Mock
    SessionService sessionService;

    @BeforeEach
    void setUp() {
        mockmvc = MockMvcBuilders.standaloneSetup(sessionController).setControllerAdvice(handler).build();
    }

    @Test
    void test_createNewSession_shouldReturnNewSession() throws Exception {
        Session session = new Session("OwkZLGZFJQRjBdzd19wCF3yS9kd22h");
        when(sessionService.createNewSession()).thenReturn(session);
        mockmvc.perform(get("/v1/sessions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("key").value(session.getKey()));
    }

    @Test
    void test_createNewSession_methodNotAllowed() throws Exception {
        mockmvc.perform(post("/v1/sessions"))
                .andExpect(status().isMethodNotAllowed());
    }
}
