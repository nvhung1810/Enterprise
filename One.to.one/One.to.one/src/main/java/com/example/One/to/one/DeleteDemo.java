package com.example.One.to.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.One.to.one.entity.Instructor;
import com.example.One.to.one.entity.InstructorDetail;

public class DeleteDemo {
	public static void main(String[] args) {
// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId = 4;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("\n Found Instructor: " + tempInstructor);
			if (tempInstructor != null) {
				System.out.println("\n Delete...");
				session.delete(tempInstructor);
			}
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}