package com.company;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Shera on 27.03.2017.
 */
@Entity
public class Cinema {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    List<Hall> halls = new ArrayList();

    public void setId(final UUID id) {
        this.id = id;
    }

    public UUID getId()
    {
        return id;
    }

    public List<Hall> getHalls()
    {
        return halls;
    }

    public void addHall(final Hall hall)
    {
        halls.add(hall);
        hall.setCinema(this);
    }

    public void removeHall(final Hall hall)
    {
        if(halls.remove(hall))
            hall.setCinema(null);
    }

}
