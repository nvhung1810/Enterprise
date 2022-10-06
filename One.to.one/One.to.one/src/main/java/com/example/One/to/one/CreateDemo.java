package com.example.One.to.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.One.to.one.entity.Instructor;
import com.example.One.to.one.entity.InstructorDetail;

public class CreateDemo {
	public static void main(String[] args) {
// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating new Instructor and InstructorDetail object...");
			Instructor tempInstructor = new Instructor("Nguyen", "Hoan", "nnhoan@hunre.edu.vn");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.nguyenhoan.com/youtube", "Game");
			session.beginTransaction();
			System.out.println("Saving the Instructor and Instructor Detail...");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
