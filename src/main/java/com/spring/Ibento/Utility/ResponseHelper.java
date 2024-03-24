package com.spring.Ibento.Utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    public static <T> ResponseEntity<T> createResponse(T body, HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }

    public static <T> ResponseEntity<T> createResponse(HttpStatus status) {
        return new ResponseEntity<>(status);
    }

    public static <T> ResponseEntity<T> createErrorResponse(String message, HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse(message);
        return (ResponseEntity<T>) new ResponseEntity<>(errorResponse, status);
    }

    private static class ErrorResponse {
        private final String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
