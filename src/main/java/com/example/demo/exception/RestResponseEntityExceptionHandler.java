package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(status);

//        error.setErrors(exception.getAllErrors().stream().map(objectError ->
//                objectError.getObjectName()+"."+ ((FieldError) objectError).getField() + " => " + objectError.getDefaultMessage()
//        ).collect(Collectors.toList()));


        error.setErrors(exception.getAllErrors().stream().map(objectError ->
                objectError.getObjectName() + " => " + objectError.getDefaultMessage()
        ).collect(Collectors.toList()));
        System.out.println(exception.getAllErrors());
        return new ResponseEntity(error, headers, status);
    }
}