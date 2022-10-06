package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new
		ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		Coach theCoach=context.getBean("myCoach",Coach.class);
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		boolean result=(theCoach==alphaCoach);
		System.out.println("Dung hay sai "+result);
		System.out.println("/n memory the coach: "+theCoach);
		System.out.println("/n memory the coach: "+alphaCoach);
		context.close();
		}
}
