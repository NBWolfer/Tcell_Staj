package org.example.staj_projesi.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private int status;
    private String message;
    private  List<ErrorDetail> details;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, List<ErrorDetail> details) {
        this.status = status;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
}


