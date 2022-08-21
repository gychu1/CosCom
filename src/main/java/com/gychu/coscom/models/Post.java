package com.gychu.coscom.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageURL;
    private String description;
    @OneToMany(mappedBy = "post") // One post contains many comments hence List<Comment>. It is mapped by the variable in Comment class that represents the Post class.
    private List<Comment> comments;
    @ManyToOne // ManyToOne relationship with a user. Meaning There are many POST that belong to a specific USER.
    private User user;
    private LocalDate date;

    public Post() {
    }

    public Post(Long id, String imageURL, String description, List<Comment> comments, User user, LocalDate date) {
        this.id = id;
        this.imageURL = imageURL;
        this.description = description;
        this.comments = comments;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
