package com.springinaction.chapter01.knights.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springinaction",
               excludeFilters = { @Filter(Configuration.class) })
public class SoundSystemConfig {
}
