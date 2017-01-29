package com.manardenza.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User extends AbstractObject implements Serializable {

    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
