package com.mq.yaomq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:local/config.properties")
public class YaomqApplication {

    public static void main(String[] args) {
        SpringApplication.run(YaomqApplication.class, args);
    }

}
