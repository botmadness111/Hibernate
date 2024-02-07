package org.example;

import org.example.models.Director;
import org.example.models.Item;
import org.example.models.Movie;
import org.example.models.Person;
import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class).addAnnotatedClass(Director.class);
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class).addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 5);
            session.remove(movie);

            Director director = session.get(Director.class, 1);
            director.getMovies().remove(movie);
        //try with resources (автоматически закрывает ресурсы)
        try (sessionFactory) {
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 2);
            Actor actor = session.get(Actor.class, 1);

//            System.out.println(movie.getActors());
//            System.out.println(actor.getMovies());

//            actor.getMovies().add(movie);
//            movie.getActors().add(actor);

            movie.getActors().remove(actor);
            actor.getMovies().remove(movie);

            session.getTransaction().commit();
        }

    }
}
