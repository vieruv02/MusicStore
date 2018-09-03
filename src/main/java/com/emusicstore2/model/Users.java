package com.emusicstore2.model;

import javax.persistence.*;

/**
 * Created by vladvieru on 8/19/18.
 */

//That will be used to show a list of customers

@Entity
public class Users {


    //  We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "userId")

    @Id
    @GeneratedValue
    private int userId;

    private String username;
    private String password;
    private boolean enabled;
    private int customerId;


    //Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

