package com.example.Hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Hibernate.demo.controller.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")						
									.addAnnotatedClass(Student.class)							
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int studentID = 1;
			session.beginTransaction();
			System.out.println("\n Delete Student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}
}
