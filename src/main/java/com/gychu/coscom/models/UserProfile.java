package com.gychu.coscom.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String username;
    private String name;
    @NotNull
    private int age;
    private String profileImage;
    @OneToMany(mappedBy = "userProfile") // One USER have many comments.
    @JsonIgnore
    private List<Comment> comments;
    @OneToMany(mappedBy = "userProfile") // One USER have many posts.
    @JsonIgnore
    private List<Post> posts;

    public UserProfile() {
    }

    public UserProfile(Long id, String email, String username, String name, int age, String profileImage, List<Comment> comments, List<Post> posts) {
        this.id = id;
        this.email = email;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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
