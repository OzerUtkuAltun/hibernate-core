package com.ozerutkualtun.hibernate;

import com.ozerutkualtun.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Student student = new Student("John", "Doe", "jonh_doe@mail.com");
            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
