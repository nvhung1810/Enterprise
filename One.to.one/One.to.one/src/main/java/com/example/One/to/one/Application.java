package com.example.One.to.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.One.to.one.entity.Instructor;
import com.example.One.to.one.entity.InstructorDetail;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
//			add thông tin riêng
			Instructor instructor = 
					new Instructor("Hà", "Nguyễn Thu", "nguyenthuha@gmail.com");
			InstructorDetail instructorDetail = 
					new InstructorDetail("youtube/nguyenthuha", "none");
//			add liên kết
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			
			session.save(instructor);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.print("Lỗi");
		}
	}

}
