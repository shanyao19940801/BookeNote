package com.springinaction.chapter01.knights.main;

import com.springinaction.chapter01.knights.Knight;
import com.springinaction.chapter01.knights.Minstrel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MinstrelMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/minstrel.xml");
//        Minstrel minstrel = context.getBean("minstrel");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
