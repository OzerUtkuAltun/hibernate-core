package com.ozerutkualtun.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student s where  s.lastName = 'Altun' ").getResultList();
            students.forEach(System.out::println);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
