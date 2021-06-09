package com.web.app.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.app.user.User;

import javax.persistence.*;

@Entity
public class Post {


    @Id
    @GeneratedValue
    private int id;
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;



    public Post() {

    }


    public Post(String message, int id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Post{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
