package com.andrewsdosreis.rockpaperscissors.controller;

import com.andrewsdosreis.rockpaperscissors.controller.output.UserDto;
import com.andrewsdosreis.rockpaperscissors.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController extends BaseController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserDto> generateSession() {
        return ok(userService.createNewGameSession());
    }
}
