package com.foo.app.rest;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;
import java.util.List;

@Value
@Builder
public class ErrorDto {
    Instant time;
    int status;
    String message;
    String path;
    String method;
    List<ValidationError> errors;
    @Value
    public static class ValidationError {
        String field;
        String message;
        
    }
}
