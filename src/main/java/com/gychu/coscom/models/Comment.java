package com.gychu.coscom.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne // There are many COMMENTS belonging to one USER
    private User user;
    @ManyToOne // There are many COMMENTS belonging to one POST
    private Post post;
    private LocalDate date;

    public Comment() {
    }

    public Comment(Long id, String text, User user, LocalDate date) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
