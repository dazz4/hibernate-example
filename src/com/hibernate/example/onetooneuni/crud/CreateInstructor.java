package com.hibernate.example.onetooneuni.crud;

import com.hibernate.example.onetooneuni.domain.Instructor;
import com.hibernate.example.onetooneuni.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hb-01-one-to-one-uni.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Instructor instructor =
                    new Instructor("Darek", "Kaminski", "darek@mail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("youtube.com/dazz4", "programming");

            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            System.out.println(instructor + "\n");
            System.out.println(instructorDetail);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }
}
