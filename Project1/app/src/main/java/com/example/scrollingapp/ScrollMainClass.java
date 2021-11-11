package com.example.scrollingapp;

public class ScrollMainClass {
    private User userdata;
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
    public void setUser(String id,String name){
        this.userdata=new User(id,name);
    }
    public User getUser(){
        return userdata;
    }


    public class User{
        String id;
        String name;

        public User() {
        }

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
