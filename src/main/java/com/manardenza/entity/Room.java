package com.manardenza.entity;

import lombok.Data;

@Data
public class Room extends AbstractObject {

    private String name;
    private int person;
    private int price;

    public Room(String name, int person, int price) {
        this.name = name;
        this.person = person;
        this.price = price;
    }
}
