package com.example.onetomany.Controller;

import com.example.onetomany.Entity.Course;
import com.example.onetomany.Entity.Instructor;
import com.example.onetomany.Entity.InstructorDetail;

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
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
//            ở cái này phải trỏ đến id của instructorDetail trong database
//            nếu không sẽ báo lỗi không tồn tại id
            int idInstructorDetail = 1;
            Instructor tempInstructor = session.get(Instructor.class, idInstructorDetail);
            Course tempCourse1 = new Course("Android");
            tempInstructor.addCourse(tempCourse1);
            session.save(tempCourse1);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }

}
