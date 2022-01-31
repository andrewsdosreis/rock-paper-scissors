package com.andrewsdosreis.rockpaperscissors.interceptor;

import java.util.Optional;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrewsdosreis.rockpaperscissors.exception.SessionKeyHeaderIsNotPresent;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<String> sessionHeader = Optional.ofNullable(request.getHeader("SESSION-KEY"))
                                                 .filter(Predicate.not(String::isEmpty));
        
        if (sessionHeader.isEmpty() && !request.getMethod().equals(HttpMethod.OPTIONS.toString()))
            throw new SessionKeyHeaderIsNotPresent();

        return Boolean.TRUE;
    }
}
