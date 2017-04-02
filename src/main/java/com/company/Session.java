package com.company;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Shera on 27.03.2017.
 */
@Entity
public class Session {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Hall hall;

  /*  public void setId(final UUID id) {
        this.id = id;
    }
    */

    public UUID getId()
    {
        return id;
    }

    public void setMovie(final Movie movie)
    {
        this.movie=movie;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(final Hall hall) {
        this.hall = hall;
    }
}
