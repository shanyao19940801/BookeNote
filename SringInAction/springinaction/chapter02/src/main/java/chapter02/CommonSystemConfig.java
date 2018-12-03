package chapter02;

import chapter02.c03.config.JavaConfig;
import chapter02.config.CDPlayerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JavaConfig.class,CDPlayerConfig.class})
public class CommonSystemConfig {
}
