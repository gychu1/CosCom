package com.gychu.coscom.models;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Comment {

    String text;
    User user;
    LocalDate date;
}
