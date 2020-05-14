package com.hibernate.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

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
            Student newStudent = new Student("John", "Smith", "kaminski.darek@icloud.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            session.save(newStudent);

            session.getTransaction().commit();

            System.out.println("Done.");
        } finally {
            factory.close();
        }
    }
}
