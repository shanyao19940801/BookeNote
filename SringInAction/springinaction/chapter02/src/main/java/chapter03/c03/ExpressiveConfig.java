package chapter03.c03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
//声明属性源
@PropertySource("classpath:app.properties")
public class ExpressiveConfig {
    @Autowired
    Environment environment;

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(environment.getProperty("disc.title"));
    }
}
