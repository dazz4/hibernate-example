package com.hibernate.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

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
            Student newStudent = new Student("Zoe", "Willson", "zoe@mail.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            System.out.println(newStudent);
            session.save(newStudent);
            session.getTransaction().commit();

            // get the student
            System.out.println("Saved student. Generated id: " + newStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with id: " + newStudent.getId());
            Student myStudent = session.get(Student.class, newStudent.getId());

            System.out.println("Get complete: " + myStudent );
            session.getTransaction().commit();

            System.out.println("Done.");
        } finally {
            factory.close();
        }
    }
}
