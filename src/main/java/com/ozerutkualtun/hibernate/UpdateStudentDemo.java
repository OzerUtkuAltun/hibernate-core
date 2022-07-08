package com.ozerutkualtun.hibernate;

import com.ozerutkualtun.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Integer studentId = 1;

            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            student.setFirstName("Updated Firstname");
            student.setEmail("updated@updated.com");

            session.save(student);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
