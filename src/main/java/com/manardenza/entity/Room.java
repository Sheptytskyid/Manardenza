package com.manardenza.entity;

import lombok.Data;

import java.util.Formatter;

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        String template = "%-30s %-15s %-10s";
        formatter.format(template, "type = " + name, "person = " + person, "price = " + price + "\n");
        return stringBuilder.toString();
    }
}
