package com.chaptor07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spittle/")
public class Spittler {

    @PostMapping("execption_test")
    public String saveSpittle() {
        int i = 2;
        float b = 1.0f;
        b = i/0;
        return "yes";
    }

    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException() {
        return "exceptionhandle";
    }
}
