package com.yao.springstudy.controller;

import com.yao.springstudy.configuration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShutDownController {
    @Autowired
    Person p1;
    @Autowired
    Person p2;
    @RequestMapping(value = "/spring_test", method = RequestMethod.POST)
    public String test() {
        System.out.println("shutdown");
        System.out.println(p1);
        System.out.println(p2);
        return "test";
    }
}
