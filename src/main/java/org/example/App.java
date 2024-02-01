package org.example;

import org.example.models.Item;
import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//
//            List<Item> items = person.getItems();
//            System.out.println(items);
//
//            Item item = session.get(Item.class, 5);
//            Person owner = item.getOwner();
//            System.out.println(owner);
//
//            Item newItem = new Item("Item Name", person);
//            person.getItems().add(newItem);
//            session.save(newItem);

            Person bob = session.get(Person.class, 5);
            Person tom = session.get(Person.class, 4);

            Item item = session.get(Item.class, 6);
            item.setOwner(bob);

            //Тут выдаст старые значения items у боба и тома, тк они были закешированы хибернетом...
            System.out.println(bob.getItems());
            System.out.println(tom.getItems());


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
