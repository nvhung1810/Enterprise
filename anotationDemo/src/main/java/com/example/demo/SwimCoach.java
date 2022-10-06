package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	private FortuneService fortuneService;
	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
	// TODO Auto-generated method stub
		return "Dailly Workout";
	}
	@Override
	public String getFortune() {
	// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}