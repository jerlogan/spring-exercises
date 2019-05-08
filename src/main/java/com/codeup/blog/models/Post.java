package com.codeup.blog.models;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false, length=100)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne
    private Sport sport;

    @OneToOne
    private Team team;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User author;




//    CONSTRUCTORS


    public Post() {

    }

    public Post(String title, String body, Sport sport, Team team, User author) {
        this.title = title;
        this.body = body;
        this.sport = sport;
        this.team = team;
        this.author = author;
    }

    //GETTERS, SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
