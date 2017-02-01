package com.manardenza.controller;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;
import com.manardenza.service.ReservationService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public final class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public Long bookRoom(Date reservedFrom, Date reservedTo, Room room, Hotel hotel) {
        return reservationService.bookRoom(reservedFrom, reservedTo, room, hotel);
    }

    public boolean cancelReservation(long idReservation) {
        return reservationService.cancelReservation(idReservation);
    }

    public Map<String, List<Room>> checkRoomReservation(Date reservedFrom, Date reservedTo,
                                                        Map<String, List<Room>> rooms) {
        return reservationService.checkRoomReservation(reservedFrom, reservedTo, rooms);
    }

    private List<Reservation> getAllUserReservations() {
        return reservationService.getAllUserReservations();
    }
}
