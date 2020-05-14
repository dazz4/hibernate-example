package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKey {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object...");
            Student newStudent1 = new Student("John", "Smith", "johnsmith@mail.com");
            Student newStudent2 = new Student("Jan", "Nowak", "jannowak@mail.com");
            Student newStudent3 = new Student("John", "Doe", "jonedoe@mail.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            session.save(newStudent1);
            session.save(newStudent2);
            session.save(newStudent3);

            session.getTransaction().commit();

            System.out.println("Done.");
        } finally {
            factory.close();
        }
    }
}
