package com.casa.demospring.demo.controller.exceptions;

import com.casa.demospring.demo.services.exceptions.ConflictException;
import com.casa.demospring.demo.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends RuntimeException{


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(java.time.Instant.now());
        error.setStatus(404);
        error.setError(e.getMessage());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<StandardError> conflict(ConflictException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(java.time.Instant.now());
        error.setStatus(409);
        error.setError(e.getMessage());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(409).body(error);
    }
}
