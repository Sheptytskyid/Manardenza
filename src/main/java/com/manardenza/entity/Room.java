package com.manardenza.entity;

import lombok.Data;

@Data
public class Room extends AbstractObject {

    private long id;
    private String name;
    private int person;
    private int price;

    public Room(String name, int person, int price) {
        id = super.getId();
        this.name = name;
        this.person = person;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{"
                + "name='" + name + '\''
                + ", person=" + person
                + ", price=" + price
                + '}';
    }
}
