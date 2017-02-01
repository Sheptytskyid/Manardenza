package com.manardenza.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Reservation extends AbstractObject {

    private Date reservedFrom;
    private Date reservedTo;
    private User reservedUser;
    private Room reservedRoom;
    private Hotel reservedHotel;

    public boolean overlaps(Date newReservedFrom, Date newReservedTo) {
        return reservedFrom.getTime() <= newReservedTo.getTime() && newReservedFrom.getTime() <= reservedTo.getTime();
    }
}
