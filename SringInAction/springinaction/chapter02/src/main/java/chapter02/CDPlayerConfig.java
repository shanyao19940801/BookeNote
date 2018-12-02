package chapter02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//这里如果没有其他配置，默认扫描与配置类相同的包
@Configuration
@ComponentScan
public class CDPlayerConfig {
}
