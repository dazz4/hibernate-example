package com.hibernate.example.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            int studentId = 1;
            session.beginTransaction();

            Student myStudent = session.get(Student.class, studentId);

            session.delete(myStudent);
            // session.createQuery("delete from Student where id=1").executeUpdate();

            session.getTransaction().commit();
        }
    }
}
