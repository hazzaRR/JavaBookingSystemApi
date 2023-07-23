package com.hazr.JavaBookingSystemApi.model;


import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

    private String username;

    protected Admin() {}

    public Admin (String password, String username) {
        super(password);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                '}';
    }
}
