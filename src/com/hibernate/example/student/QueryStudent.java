package com.hibernate.example.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        try (Session session = factory.getCurrentSession()) {

            // start transaction
            session.beginTransaction();

            // query students
            List<Student> list1 = session.createQuery("from Student").getResultList();
            List<Student> list2 = session.createQuery("from Student s where s.lastName='Smith'").getResultList();
            List<Student> list3 = session.createQuery("from Student s where s.lastName='Smith'" +
                    " OR s.firstName='Zoe'").getResultList();
            List<Student> list4 = session.createQuery("from Student s where s.email like '%mail.com'").getResultList();

            // display student
            displayStudent(list4);

            //commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    private static void displayStudent(List<Student> students) {
        for(Student theStudent: students) {
            System.out.println(theStudent);
        }
    }
}
