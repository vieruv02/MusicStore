package com.emusicstore2.model;

import javax.persistence.*;

/**
 * Created by vladvieru on 8/19/18.
 */

@Entity
public class Authorities
{

//We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "authoritiesId")

    @Id
    @GeneratedValue
    private int authoritiesId;

    private String username;
    private String authority;


    //Getters and setters
    public int getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(int authoritiesId) {
        this.authoritiesId = authoritiesId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
