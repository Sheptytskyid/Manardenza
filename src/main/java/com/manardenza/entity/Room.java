package com.manardenza.entity;

import lombok.Data;

@Data
public class Room extends AbstractObject {

    private String name;
    private int person;
    private int price;
    private Reservation reservation;

    public Room(long id, String name, int person, int price, Reservation reservation) {
        super(id);
        this.name = name;
        this.person = person;
        this.price = price;
        this.reservation = reservation;
    }
}
