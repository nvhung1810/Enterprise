package com.example.onetomany.Controller;

import com.example.onetomany.Entity.Course;
import com.example.onetomany.Entity.Instructor;
import com.example.onetomany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletetInstructorCoursesDemo {
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
            int idCourse = 5;
            Course tempCourse = session.get(Course.class, idCourse);
            System.out.println("Deleting Course...: " + tempCourse);
            session.delete(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }

}
