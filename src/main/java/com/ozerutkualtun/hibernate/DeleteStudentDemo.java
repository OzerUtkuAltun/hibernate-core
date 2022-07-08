package com.ozerutkualtun.hibernate;

import com.ozerutkualtun.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Integer studentId = 6;

            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            session.delete(student);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
