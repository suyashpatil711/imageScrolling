package com.example.scrollingapp;

public class ScrollMainClass {
    String id;
    String likes;

    public ScrollMainClass() {
    }

    public ScrollMainClass(String id, String likes) {
        this.id = id;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
