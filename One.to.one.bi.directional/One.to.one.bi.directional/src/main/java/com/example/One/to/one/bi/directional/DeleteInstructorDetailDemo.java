package com.example.One.to.one.bi.directional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.One.to.one.bi.directional.entity.Instructor;
import com.example.One.to.one.bi.directional.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("\n tempInstructorDetail: " + tempInstructorDetail);
			System.out.println("\n the associated Instructor: " + tempInstructorDetail.getInstructor());
			System.out.println("Deleting....");
			session.delete(tempInstructorDetail);
			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
