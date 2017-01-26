package com.manardenza.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Reservation {

    private Date reservedFrom;
    private Date reservedTo;
    private User reservedUser;
}
