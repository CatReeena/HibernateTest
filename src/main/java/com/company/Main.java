package com.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
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

     Cinema cinema = new Cinema();
     Hall hall = new Hall();
     Movie movie = new Movie();
     Session session = new Session();

     cinema.addHall(hall);
     entityManager.persist(cinema);

     entityManager.persist(cinema);
     hall.addSession(session);
     movie.addSession(session);

     entityManager.persist(movie);
    entityManager.getTransaction().commit();


     entityManager.close();
    entityManager = emf.createEntityManager();
    entityManager.getTransaction().begin();

    Cinema foundCinema = entityManager.find(Cinema.class, cinema.getId());

     entityManager.getTransaction().commit();
     entityManager.close();
     emf.close();



    }
}
