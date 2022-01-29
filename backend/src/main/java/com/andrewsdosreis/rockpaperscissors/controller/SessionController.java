package com.andrewsdosreis.rockpaperscissors.controller;

import com.andrewsdosreis.rockpaperscissors.controller.output.NewSessionDto;
import com.andrewsdosreis.rockpaperscissors.service.SessionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sessions")
public class SessionController extends BaseController {
    
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public ResponseEntity<NewSessionDto> generateSession() {
        String key = sessionService.generateNewKey();
        NewSessionDto newSession = new NewSessionDto();
        newSession.setKey(key);
        return ok(newSession);
    }
}
