package com.techpalle.karan.fragmentdemoproject.model;

/**
 * Created by ADMIN on 9/11/2016.
 */
public class User {
    private int id;
    private String username, password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
