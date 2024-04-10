package com.foo.app.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RestControllerAdvice

public class PersonApiRestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e, WebRequest request) {
        log.warn("ConstraintViolationException:", e);

        Function<ConstraintViolation, ErrorDto.ValidationError> constraintViolationMapper = v -> {
            var arr = v.getPropertyPath().toString().split("\\.");
            var node = arr.length == 0 ? "" : arr[arr.length - 1];
            return new ErrorDto.ValidationError(node, v.getMessage());
        };
        var validationErrors = e.getConstraintViolations().stream()
                .map(constraintViolationMapper)
                .collect(Collectors.toList());

        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Invalid URL parameters", request, validationErrors);
    }

    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(v -> new ErrorDto.ValidationError(v.getField(), v.getDefaultMessage()))
                .collect(Collectors.toList());

        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Invalid payload", request, fieldErrors);
    }


    private ResponseEntity<Object> buildErrorResponse(
            HttpStatus httpStatus, String message,
            WebRequest request,
            List<ErrorDto.ValidationError> errors) {
        var customErrorResponse =
                new ErrorDto(Instant.now(), httpStatus.value(), message, getPath(request),
                        getMethod(request), errors);

        return ResponseEntity.status(httpStatus).body(customErrorResponse);
    }

    private ResponseEntity<Object> buildErrorResponse(Exception exception,
                                                      HttpStatus httpStatus,
                                                      WebRequest request) {
        return buildErrorResponse(httpStatus, exception.getMessage(), request, Collections.emptyList());
    }

    private static String getPath(WebRequest request) {
        var url = ((ServletWebRequest) request).getRequest().getRequestURI();
        return url.substring(url.indexOf('/'));
    }

    private static String getMethod(WebRequest request) {
        return ((ServletWebRequest) request).getHttpMethod().name();
    }

}


