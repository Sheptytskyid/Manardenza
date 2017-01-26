package com.manardenza.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Reservation extends AbstractObject {

    private LocalDate reservedFrom;
    private LocalDate reservedTo;
    private User reservedUser;

    public Reservation(long id, LocalDate reservedFrom, LocalDate reservedTo, User reservedUser) {
        super(id);
        this.reservedFrom = reservedFrom;
        this.reservedTo = reservedTo;
        this.reservedUser = reservedUser;
    }
}
