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
        if (newReservedFrom.after(reservedFrom) && newReservedFrom.before(reservedTo)) {
            return true;
        }
        if (newReservedTo.after(reservedFrom) && newReservedTo.before(reservedTo)) {
            return true;
        }
        if (newReservedFrom.before(reservedFrom) && newReservedTo.after(reservedTo)) {
            return true;
        }
        if (newReservedFrom.equals(reservedFrom) || newReservedTo.equals(reservedTo)) {
            return true;
        }
        return false;
    }
}
