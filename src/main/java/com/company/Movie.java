package com.company;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Shera on 27.03.2017.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    List<Session> sessions = new ArrayList();

    public void setId(final UUID id) {
        this.id = id;
    }

    public UUID getId()
    {
        return id;
    }
    public List<Session> getSessions()
    {
        return sessions;
    }

    public void addSession(final Session session)
    {
        sessions.add(session);
        session.setMovie(this);
    }

    public void removeSession(final Session session)
    {
        sessions.remove(session);
        session.setMovie(null);
    }
}
