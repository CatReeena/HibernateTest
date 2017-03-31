package com.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class Main {

    public static void main(String[] args) {
     //   Session s = new Session(LocalDateTime.now(), UUID.randomUUID(), UUID.randomUUID());
// Create an EMF for our CRM persistence-unit.


     EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
     EntityManager entityManager = emf.createEntityManager();
     entityManager.getTransaction().begin();
     Cinema c = new Cinema();
     Hall h = new Hall();
     c.addHall(h);
     Movie m = new Movie();
     Session s = new Session();
     h.addSession(s);
     m.addSession(s);


     entityManager.persist(m);

     entityManager.getTransaction().commit();
     entityManager.close();
     emf.close();



    }
}
