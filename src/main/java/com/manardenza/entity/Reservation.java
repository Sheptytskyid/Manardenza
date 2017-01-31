package com.manardenza.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class Reservation extends AbstractObject implements Serializable {

    private Date reservedFrom;
    private Date reservedTo;
    private User reservedUser;
    private Room reservedRoom;
    private Hotel reservedHotel;
}
