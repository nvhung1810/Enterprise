package com.example.onetomany.Controller;

import com.example.onetomany.Entity.Course;
import com.example.onetomany.Entity.Instructor;
import com.example.onetomany.Entity.InstructorDetail;

import com.example.onetomany.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// HÀM TẠO DỮ LIỆU COURSE
public class CreateCoursesDemo {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Course tempCourse = new Course("Android");
            tempCourse.addReview(new Review("Good"));
            tempCourse.addReview(new Review("Great"));
            tempCourse.addReview(new Review("Best"));
            System.out.println("Saving the Course...");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }

}
