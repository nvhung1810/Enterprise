package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new
		ClassPathXmlApplicationContext("anotationApp.xml");
//		1- 6
//		Coach theCoach=context.getBean("tennisCoach",Coach.class);
//		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
//		boolean result = (theCoach==alphaCoach);
//		System.out.println("giong nhau ko "+result);
//		System.out.println("memory the coach: "+theCoach);
//		System.out.println("memory alpha coach: "+alphaCoach);
		
		
//		demo 7
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		context.close();
	}
	
}	
