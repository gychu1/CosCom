package com.gychu.coscom.models;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Post {

    String image;
    String text;
    List<Comment> comments;
    User user;
    LocalDate date;
}
