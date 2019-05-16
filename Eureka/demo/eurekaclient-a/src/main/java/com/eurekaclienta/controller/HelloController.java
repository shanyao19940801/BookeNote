package com.eurekaclienta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shanyao on 2019/5/16
 */
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);



    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        logger.info("hello A");
        return "Hellow A";
    }
}
