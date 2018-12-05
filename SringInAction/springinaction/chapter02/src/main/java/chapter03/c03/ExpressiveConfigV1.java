package chapter03.c03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//声明属性源
@PropertySource("classpath:app.properties")
public class ExpressiveConfigV1 {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Value(value = "${disc.title}")
    String title;
    @Bean
    public BlankDisc blankDisc(){
        return new BlankDisc(title);
    }
}
