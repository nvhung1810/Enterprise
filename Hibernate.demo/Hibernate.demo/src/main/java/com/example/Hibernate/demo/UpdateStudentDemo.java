package com.example.Hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Hibernate.demo.controller.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")						
									.addAnnotatedClass(Student.class)							
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;
			session.beginTransaction();
			
//			id của student sẽ lấy là
			System.out.println("\n Getting student with id: "+ id);
			
			Student myStudent = session.get(Student.class, id);
			System.out.println("Update Student.... "+ myStudent);
			
			myStudent.setFirstName("Vuong");
			session.getTransaction().commit();
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\n Update All Students");
			
			session.createQuery("update Student set email='@hunre.edu.vn'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}
}
