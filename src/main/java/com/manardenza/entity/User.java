package com.manardenza.entity;

import lombok.Data;

@Data
public class User extends AbstractObject {

    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
