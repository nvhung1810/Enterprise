package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new
		AnnotationConfigApplicationContext(SportConfig.class);
		SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());
		context.close();
	}
}
