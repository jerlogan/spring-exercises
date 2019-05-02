package com.codeup.blog.models;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable=false, length=100)
    private String title;

    @Column(nullable = false)
    private String body;


//    CONSTRUCTORS


    public Post() {

    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    //    SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }


//    GETTERS

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Long getId() {
        return id;
    }
}
