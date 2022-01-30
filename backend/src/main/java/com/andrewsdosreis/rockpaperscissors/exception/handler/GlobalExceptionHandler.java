package com.andrewsdosreis.rockpaperscissors.exception.handler;

import javax.servlet.http.HttpServletRequest;

import com.andrewsdosreis.rockpaperscissors.exception.UserKeyHeaderIsNotPresent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String ERROR = "Error => {}";

    @ExceptionHandler({ UserKeyHeaderIsNotPresent.class })
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorHandler> handleUserKeyHeaderIsNotPresent(UserKeyHeaderIsNotPresent e, HttpServletRequest request) {
        var errorHandler = createErrorHandler(HttpStatus.UNAUTHORIZED, e.getMessage(), request);
        LOGGER.error(ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorHandler);
    }

    @ExceptionHandler({ RuntimeException.class })
    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<ErrorHandler> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        var errorHandler = createErrorHandler(HttpStatus.EXPECTATION_FAILED, e.getMessage(), request);
        LOGGER.error(ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errorHandler);
    }

    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<ErrorHandler> handleMethodNotAllowed(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        var errorHandler = createErrorHandler(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage(), request);
        LOGGER.error(ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorHandler);
    }

    @ExceptionHandler({ Exception.class })
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorHandler> handle(Exception e, HttpServletRequest request) {
        var errorHandler = createErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), request);
        LOGGER.error(ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorHandler);
    }

    private ErrorHandler createErrorHandler(HttpStatus httpStatus, String message, HttpServletRequest request) {
        var errorHandler = new ErrorHandler();
        errorHandler.timestamp(System.currentTimeMillis());
        errorHandler.status(httpStatus.value());
        errorHandler.error(httpStatus.toString());
        errorHandler.message(message);
        errorHandler.path(request.getRequestURI());
        errorHandler.method(request.getMethod());

        return errorHandler;
    }
}
