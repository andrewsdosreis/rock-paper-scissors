package com.andrewsdosreis.rockpaperscissors.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrewsdosreis.rockpaperscissors.exception.UserKeyHeaderIsNotPresent;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<String> sessionHeader = Optional.ofNullable(request.getHeader("User-Key"));
        
        if (sessionHeader.isEmpty())
            throw new UserKeyHeaderIsNotPresent();

        return Boolean.TRUE;
    }
}
