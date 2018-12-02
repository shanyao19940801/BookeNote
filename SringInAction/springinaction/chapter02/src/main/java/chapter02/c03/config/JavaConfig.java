package chapter02.c03.config;

import chapter02.SgtPeppers;
import chapter02.page_1.DVDPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    //创建一个bean实例，并将其注册到Spring应用上下文
    @Bean
    public SgtPeppers sgtPeppers(){
        return new SgtPeppers();
    }
    @Bean
    public DVDPlayer dvdPlayer() {
        //这里其实并不是掉用方法sgtPeppers()来获取bean，spring会拦截这个调用并将已经创建的bean返回
        return new DVDPlayer(sgtPeppers());
    }
}
