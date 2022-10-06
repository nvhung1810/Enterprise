package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
//	@Autowired
//	@Qualifier("randomFortuneService")
//	private FortuneService fortuneService;
//	@Override
//	public String getDailyWorkout() {
//		return "Tennis Coach";
//	}
//	public TennisCoach() {
//		System.out.println("Chay ham khoi tao tennis Coach");
//	}
//	public String getFortune() {
//		return fortuneService.getFortune();
//	}
	
//	Demo 7
	
//	@PostConstruct
//	public void doMyStartupStuff() {
//		System.out.println("bat dau");
//	}
//	@PreDestroy
//	public void doMyCleanupStuff() {
//		System.out.println("ket thuc");
//	}
//	@Override
//	public String getDailyWorkout() {
//		return "Tennis Coach";
//	}
//	public TennisCoach() {
//		System.out.println("Chay ham khoi tao tennis Coach");
//	}
	
//	Demo 8
	
	@Override
	public String getDailyWorkout() {
		return "Tennis Coach";
	}
	public String getFortune() {
		return "ABC" ;
	}
}
