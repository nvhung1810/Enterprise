package com.example.Hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Hibernate.demo.controller.Student;

public class ReadStudentDemo {
	public static void main(String[] arg) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Nguyen","Hung","nvhung@hunre.edu.vn");
			
			session.beginTransaction();
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Saved Student. Generated ID: " +tempStudent.getId());
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\n Getting student with id: " +tempStudent.getId());
			
			Student
			myStudent=session.get(Student.class,tempStudent.getId());
			System.out.println("Getting Student: "+myStudent);
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}
}
