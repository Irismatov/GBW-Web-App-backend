package com.example.gbwwebappbackend.exceptions.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        Map<String, Map<String, String >> errors = new HashMap<>();

        Map<String, String> fieldErrorDto = new HashMap<>();


        fieldErrors.forEach(fieldError -> {
            fieldErrorDto.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        errors.put("error", fieldErrorDto);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errors);
    }
}
