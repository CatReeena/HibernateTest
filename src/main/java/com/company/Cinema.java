package com.company;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Shera on 27.03.2017.
 */
@Entity
public class Cinema {
    @Id
    @GeneratedValue
    @Column( columnDefinition = "BINARY(16)", length = 16 )
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema")
    Set<Hall> halls = new HashSet<>();

    public void setId(final UUID id) {
        this.id = id;
    }

    public UUID getId()
    {
        return id;
    }

    public Set<Hall> getHalls()
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
