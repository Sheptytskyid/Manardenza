package com.manardenza.dao;

import com.manardenza.entity.Reservation;

import java.io.File;

public class ReservationDaoImpl extends AbstractDao<Reservation> {

    private static ReservationDaoImpl instance;

    private ReservationDaoImpl() {
        super(new File("src/main/resources/databaseFiles/databaseReservationsFile.bin"));
    }

    public static ReservationDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReservationDaoImpl();
        }
        return instance;
    }
}
