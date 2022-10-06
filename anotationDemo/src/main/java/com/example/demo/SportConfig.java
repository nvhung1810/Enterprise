package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("classpath:sport.properties")

public class SportConfig {
	@Bean
	public FortuneService sadFortuneServie() {
	return new SadFortuneService();
	}
	@Bean
	public Coach swimCoach() {
	return new SwimCoach(sadFortuneServie());
	}
}
