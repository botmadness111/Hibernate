package org.example;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director7 = session.get(Director.class, 7);

            School school5 = director7.getSchool();
            School newSchool6 = new School(10);

            director7.setSchool(null);
            school5.setDirector(null);

            session.update(school5);
            session.save(newSchool6);

            director7.setSchool(newSchool6);
            newSchool6.setDirector(director7);

            session.save(director7);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
