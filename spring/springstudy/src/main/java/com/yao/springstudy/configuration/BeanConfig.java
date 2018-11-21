package com.yao.springstudy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean(initMethod = "init", destroyMethod = "stop")
    public Person person() {
        Person person = new Person();
        return person;
    }
}
