package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppVersionException.class)
    public ResponseEntity<Object> handleNotFoundByProductIdException(
            AppVersionException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

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


    /*

    https://github.com/sureshprajapati076/back-end/blob/master/src/main/java/com/example/demo/exception/ControllerAdvisor.java

     @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now().toString());
        body.put("status", status.value());


        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        List<ObjectError> globalerr = ex.getBindingResult().getGlobalErrors();
        if (!globalerr.isEmpty())
            errors.add(globalerr.get(0).getDefaultMessage());

        body.put("errors", errors);


        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
     */
}