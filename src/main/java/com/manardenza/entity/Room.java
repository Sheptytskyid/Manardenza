package com.manardenza.entity;

import lombok.Data;

@Data
public class Room extends AbstractObject {

    private String name;
    private int person;
    private int price;
    private Reservation reservation;

    public Room(String name, int person, int price, Reservation reservation) {
        this.name = name;
        this.person = person;
        this.price = price;
        this.reservation = reservation;
    }
}
