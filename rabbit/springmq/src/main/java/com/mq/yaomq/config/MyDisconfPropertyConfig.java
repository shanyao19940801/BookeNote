package com.mq.yaomq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @create by  单耀
 * @create date  $date$
 */
@Deprecated
@Configuration
public class MyDisconfPropertyConfig {

    public static final String PROPERTY_CONFIG = "yaoDisconfPropertyConfig";

    //需要disconf就添加
    @Bean(name = MyDisconfPropertyConfig.PROPERTY_CONFIG)
    public List<String> qingqingDisconfPropertyConfig(){
        return Arrays.asList(
                "classpath:config.properties"
        );
    }

}
