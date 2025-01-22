package org.example.staj_projesi.exception.handler;

import jakarta.validation.ConstraintViolationException;
import org.example.staj_projesi.exception.ErrorDetail;
import org.example.staj_projesi.exception.ErrorResponse;
import org.example.staj_projesi.exception.ErrorResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        errorResponseBuilder = errorResponseBuilder.setStatus(500);
        errorResponseBuilder = errorResponseBuilder.setDetails(e.getConstraintViolations().stream().map( v -> new ErrorDetail(
                v.getPropertyPath().toString(),
                v.getMessage()
        )).toList());
        errorResponseBuilder = errorResponseBuilder.setMessage("Validation failed");
        ErrorResponse errorResponse = errorResponseBuilder.createErrorResponse();
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
