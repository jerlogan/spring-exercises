package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sports")
public class Sport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String sportName;


//    CONSTRUCTORS


    public Sport() {

    }

    public Sport(String sportName) {
        this.sportName = sportName;
    }

    //    getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
