package com.example.demo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	public String getEmailAddress() {
	return emailAddress;
	}
	public String getTeam() {
	return team;
	}
	public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
	}
	public void setTeam(String team) {
	this.team = team;
	}
	public void setFortuneService(FortuneService fortuneService) {
	System.out.println("in setForunete in Cricket");
	this.fortuneService = fortuneService;
	}
	public CricketCoach() {
	super();
	System.out.println("in constructor cricket");
	}
	@Override
	public String getDailyWorkout() {
	return "hang ngay CricketCoach";
	}
	@Override
	public String getDailyFortune() {
	return fortuneService.getFortune();
	}

}

