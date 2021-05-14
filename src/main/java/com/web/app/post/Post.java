package com.web.app.post;

public class Post {
    private String message;
    private int userId;
    private int id;

    public Post(){

    }

    public Post(String message, int userId, int id) {
        this.message = message;
        this.userId = userId;
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Override
    public String toString() {
        return "Post{" +
                "message='" + message + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
