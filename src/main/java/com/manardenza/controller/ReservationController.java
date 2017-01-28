package com.manardenza.controller;

import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;
import com.manardenza.service.ReservationService;

import java.util.Date;
import java.util.List;

public final class ReservationController {

    private static ReservationController instance;
    private ReservationService reservationService;

    private ReservationController() {
        this.reservationService = ReservationService.getInstance();
    }

    public static ReservationController getInstance() {
        if (instance == null) {
            instance = new ReservationController();
        }
        return instance;
    }

    public Long bookRoom(Reservation reservation) {
        return reservationService.bookRoom(reservation);
    }

    public boolean cancelReservation(long idReservation) {
        return reservationService.cancelReservation(idReservation);
    }

    public List<Room> checkRoomReservation(Date reservedFrom, Date reservedTo, List<Room> findRooms) {
        return reservationService.checkRoomReservation(reservedFrom, reservedTo, findRooms);
    }
}
