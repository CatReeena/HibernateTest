package com.company;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Shera on 27.03.2017.
 */
@Entity
public class Hall {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Session> sessions = new ArrayList<Session>();

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

    public List<Session> getSessions()
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
