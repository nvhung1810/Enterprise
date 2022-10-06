package com.example.demo;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Su dung 30p de luyen tap";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
