package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name="teams")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String teamName;

    @OneToOne
    private Sport sport;


//    CONSTRUCTORS

    public Team() {

    }

    public Team(String teamName, Sport sport) {
        this.teamName = teamName;
        this.sport = sport;
    }

    //    getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
