package org.example;

import org.example.models.Director;
import org.example.models.Item;
import org.example.models.Movie;
import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class).addAnnotatedClass(Director.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 5);
            session.remove(movie);

            Director director = session.get(Director.class, 1);
            director.getMovies().remove(movie);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
