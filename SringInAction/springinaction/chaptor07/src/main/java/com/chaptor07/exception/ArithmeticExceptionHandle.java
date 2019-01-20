package com.chaptor07.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArithmeticExceptionHandle {
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException() {
        return "exceptionhandle";
    }
}
