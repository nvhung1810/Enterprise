package com.example.Hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Hibernate.demo.controller.Student;

@SpringBootApplication
public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			Student tempStudent= new Student("Nguyen","Hoan","nnhoan@hunre.edu.n");
			session.beginTransaction();
			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}

}
