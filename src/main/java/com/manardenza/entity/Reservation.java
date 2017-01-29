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

    public boolean newReservedOk(Date newReservedFrom, Date newReservedTo) {
        if (newReservedFrom.after(reservedFrom) && newReservedFrom.before(reservedTo)) {
            return false;
        } else if (newReservedTo.after(reservedFrom) && newReservedTo.before(reservedTo)) {
            return false;
        } else if (newReservedFrom.before(reservedFrom) && newReservedTo.after(reservedTo)) {
            return false;
        } else if (newReservedFrom.equals(reservedFrom)) {
            return false;
        } else if (newReservedFrom.equals(reservedTo)) {
            return false;
        } else if (newReservedTo.equals(reservedFrom)) {
            return false;
        } else if (newReservedTo.equals(reservedTo)) {
            return false;
        } else {
            return true;
        }
    }
}
