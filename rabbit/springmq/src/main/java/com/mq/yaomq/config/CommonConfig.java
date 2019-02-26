package com.mq.yaomq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @create by  单耀
 * @create date  2019/2/26
 */
@Deprecated
@Configuration
public class CommonConfig {
    public static final String COMMON_CONFIG_DEPENDSON = "commonConfigDependson";

    @Bean(name = COMMON_CONFIG_DEPENDSON)
    @DependsOn(
            value = {
                    MyDisconfPropertyConfig.PROPERTY_CONFIG
            }
    )
    public Boolean commonConfigDepends(){
        return Boolean.TRUE;
    }
}
