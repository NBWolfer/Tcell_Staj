package org.example.staj_projesi.exception;

import java.util.List;

public class ErrorResponseBuilder {
    private int status;
    private String message;
    private List<ErrorDetail> details;

    public ErrorResponseBuilder setStatus(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponseBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponseBuilder setDetails(List<ErrorDetail> details) {
        this.details = details;
        return this;
    }

    public ErrorResponse createErrorResponse() {
        return new ErrorResponse(status, message, details);
    }
}