package com.mq.yaomq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @create by  单耀
 * @create date  $date$
 */

@Configuration
public class MyDisconfPropertyConfig {

    //需要disconf就添加
    @Bean(name = "myDisconfPropertyConfig")
    public List<String> qingqingDisconfPropertyConfig(){
        return Arrays.asList(
                "classpath:config.properties"
        );
    }

}
