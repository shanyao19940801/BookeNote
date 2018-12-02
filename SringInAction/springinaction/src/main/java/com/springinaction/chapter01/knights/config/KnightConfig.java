package com.springinaction.chapter01.knights.config;

import com.springinaction.chapter01.knights.BraveKnight;
import com.springinaction.chapter01.knights.Knight;
import com.springinaction.chapter01.knights.SlayDragonQuest;
import com.springinaction.chapter01.knights.Quest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }
  
  @Bean
  public Quest quest() {
    return new SlayDragonQuest(System.out);
  }

}
