package com.manardenza.dao;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Reservation;

import java.util.List;

public class ReservationDaoImpl extends AbstractDao<Reservation> {

    private static ReservationDaoImpl instance;

    private ReservationDaoImpl() {
    }

    public static ReservationDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReservationDaoImpl();
        }
        return instance;
    }

    @Override
    public Reservation save(Reservation obj) {
        return super.save(obj);
    }

    @Override
    public List<Reservation> getAll() {
        return super.getAll();
    }
}
