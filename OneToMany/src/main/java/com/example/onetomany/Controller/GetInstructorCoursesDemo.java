package com.example.onetomany.Controller;

import com.example.onetomany.Entity.Course;
import com.example.onetomany.Entity.Instructor;
import com.example.onetomany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Hàm sẽ lấy ra ID của constructor
public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            int theId = 5;
            Course theCourse = session.get(Course.class, theId);
            System.out.println(theCourse);
            System.out.println(theCourse.getReviews());
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }
}
