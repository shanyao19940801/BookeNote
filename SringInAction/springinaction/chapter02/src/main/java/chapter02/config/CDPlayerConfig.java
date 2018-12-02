package chapter02.config;

import chapter02.CompactDisc;
import chapter02.page_1.DVDPlayer;
import chapter02.page_2.VCDPlayer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//这里如果没有其他配置，默认扫描与配置类相同的包
@Configuration
//通过String字符串指定扫描组件基础包，可以配置多个
//@ComponentScan(basePackages = {"chapter02.page_1","chapter02.page_2"})
//通过指定包中包含的类或接口
@ComponentScan(basePackageClasses = {DVDPlayer.class, VCDPlayer.class, CompactDisc.class})
public class CDPlayerConfig {
}
