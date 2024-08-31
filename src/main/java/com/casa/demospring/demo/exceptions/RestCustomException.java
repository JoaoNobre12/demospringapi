package com.casa.demospring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class RestCustomException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    private ResponseEntity<String> internalServerError(RuntimeException ex) {
         return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(ex.getMessage() + "DEU ERRO NO SERVIDOR JAVA");
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
}
