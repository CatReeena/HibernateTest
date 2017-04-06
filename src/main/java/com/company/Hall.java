package com.company;



import javax.persistence.*;
import java.util.*;

/**
 * Created by Shera on 27.03.2017.
 */
@Entity
public class Hall {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "BINARY(16)", length = 16 )
    private UUID id;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hall")
    private Set<Session> sessions = new HashSet<>();

    public void setId(final UUID id) {
        this.id = id;
    }


    public UUID getId()
    {
        return id;
    }

    public void setCinema(final Cinema cinema)
    {
        this.cinema = cinema;
    }

    public Cinema getCinema()
    {
        return cinema;
    }

    public Set<Session> getSessions()
    {
        return sessions;
    }

    public void addSession(final Session session)
    {
        sessions.add(session);
        session.setHall(this);
    }

    public void removeSession(final Session session)
    {
        sessions.remove(session);
        session.setHall(null);
    }
}
