package org.example;

import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //List<Person> people = session.createQuery("from Person where age=19").getResultList();

            //List<Person> people = session.createQuery("from Person where name like 'T%'").getResultList();

            session.createQuery("update Person set age=10 where name='Tom'").executeUpdate();
            List<Person> people = session.createQuery("from Person").getResultList();

            for (Person person : people) {
                System.out.println(person);
            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
