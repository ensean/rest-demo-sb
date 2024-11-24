package com.rest.example.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RestDemoError {

    private final List<Error> errors;

    public RestDemoError() {
        this.errors = new ArrayList<>();
    }

    public RestDemoError(TeacherNotFoundException ex) {
        this();
        this.addMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    public RestDemoError(UserNotFoundException ex) {
        this();
        this.addMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    private void addMessage(int code, String message) {
        this.errors.add(new Error(code, message));
    }

    public List<Error> getErrors() {
        return errors;
    }
}
