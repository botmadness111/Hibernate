package org.example;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        //try with resources (автоматически закрывает ресурсы)
        try (sessionFactory) {
            session.beginTransaction();

            Person person = session.get(Person.class, 1);

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Item> items = session.createQuery("select owner from Item where owner.id=:person_id", Item.class).setParameter("person_id", person.getId()).getResultList();
            System.out.println(items);

            session.getTransaction().commit();
        }

    }
}
