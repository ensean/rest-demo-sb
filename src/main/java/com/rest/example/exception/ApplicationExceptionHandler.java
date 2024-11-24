package com.rest.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = TeacherNotFoundException.class)
    public @ResponseBody
    ResponseEntity<RestDemoError> handleException(TeacherNotFoundException ex) {
        return new ResponseEntity<>(new RestDemoError(ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public @ResponseBody
    ResponseEntity<RestDemoError> handleException(UserNotFoundException ex) {
        return new ResponseEntity<>(new RestDemoError(ex), HttpStatus.NOT_FOUND);
    }
}
