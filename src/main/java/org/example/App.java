package org.example;

import org.example.models.Human;
import org.example.models.Item;
import org.example.models.Passport;
import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class).addAnnotatedClass(Passport.class).addAnnotatedClass(Human.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Human human = new Human("Andrey2", 19);
            Passport passport = new Passport(12358);

            human.setPassport(passport);

            session.save(human);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
