package com.example.demo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	public TrackCoach() {
	}
	public TrackCoach(FortuneService theFortuneService) {
	fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
	return "chay thu track coach";
	}
	@Override
	public String getDailyFortune() {
	return fortuneService.getFortune();
	}
	public void doMyStartupStuff() {
	System.out.println("do startup");
	}
	public void doMyCleanupStuff() {
	System.out.println("do clean up");
	}
}

