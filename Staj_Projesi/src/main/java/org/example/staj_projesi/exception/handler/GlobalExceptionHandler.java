package org.example.staj_projesi.exception.handler;

import jakarta.validation.ConstraintViolationException;
import org.example.staj_projesi.exception.ErrorDetail;
import org.example.staj_projesi.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        ErrorResponse errorResponse =  new ErrorResponse(400, "Bad Request", e.getConstraintViolations().stream()
                .map(constraintViolation -> new ErrorDetail(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()))
                .collect(Collectors.toList()));
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
