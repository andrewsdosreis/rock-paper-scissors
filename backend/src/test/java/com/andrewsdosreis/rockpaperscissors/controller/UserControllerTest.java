package com.andrewsdosreis.rockpaperscissors.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.andrewsdosreis.rockpaperscissors.controller.output.UserDto;
import com.andrewsdosreis.rockpaperscissors.exception.handler.GlobalExceptionHandler;
import com.andrewsdosreis.rockpaperscissors.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    MockMvc mockmvc;
    @InjectMocks UserController userController;
    @InjectMocks GlobalExceptionHandler handler;
    @Mock UserService userService;

    @BeforeEach
    void setUp() {
        mockmvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(handler).build();
    }

    @Test
    void test_createNewUser_shouldReturnNewUserKey() throws Exception {
        UserDto userDto = new UserDto("OwkZLGZFJQRjBdzd19wCF3yS9kd22h");
        when(userService.createNewUser()).thenReturn(userDto);
        mockmvc.perform(get("/v1/users"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("key").value(userDto.getKey()));
    }

    @Test
    void test_createNewUser_methodNotAllowed() throws Exception {
        mockmvc.perform(post("/v1/users"))
               .andExpect(status().isMethodNotAllowed());
    }
}
