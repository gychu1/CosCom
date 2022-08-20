package com.gychu.coscom.models;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String userName;
    private String name;
    @NotNull
    private int age;
    private String profileImage;
    @OneToMany(mappedBy = "user") // One USER have many comments.
    private List<Comment> comments;
    @OneToMany(mappedBy = "user") // One USER have many posts.
    private List<Post> posts;

    public User() {
    }

    public User(Long id, String email, String userName, String name, int age, String profileImage, List<Comment> comments, List<Post> posts) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.name = name;
        this.age = age;
        this.profileImage = profileImage;
        this.comments = comments;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
