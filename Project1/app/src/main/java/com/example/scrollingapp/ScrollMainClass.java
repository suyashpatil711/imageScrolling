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
        private ProfImg profimgdata;
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

        public void setProfImg(String small,String medium,String large){
            this.profimgdata=new ProfImg(small, medium, large);

        }
        public ProfImg getProfImg(){
            return profimgdata;

        }
        public class ProfImg {
            String small;
            String medium;
            String large;

            public ProfImg() {
            }

            public ProfImg(String small, String medium, String large) {
                this.small = small;
                this.medium = medium;
                this.large = large;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }

    }
}
