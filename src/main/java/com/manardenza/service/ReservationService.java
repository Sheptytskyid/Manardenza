package com.manardenza.service;

import com.manardenza.dao.ReservationDaoImpl;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ReservationService {

    private static ReservationService instance;
    private ReservationDaoImpl reservationDao;

    ReservationService() {
        this.reservationDao = ReservationDaoImpl.getInstance();
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public Long bookRoom(Reservation reservation) {
        return reservationDao.save(reservation).getId();
    }

    public boolean cancelReservation(long idReservation) {
        return reservationDao.getAll().removeIf(p -> p.getId() == idReservation);
    }

    public List<Room> checkRoomReservation(Date reservedFrom, Date reservedTo, List<Room> findRooms) {
        List<Room> toDel = new ArrayList<>();
        for (Room findRoom : findRooms) {
            if (reservationDao.getAll().stream().filter(p -> p.getReservedRoom().equals(findRoom)
                    && !p.newReservedOk(reservedFrom, reservedTo)).count() > 0) {
                toDel.add(findRoom);
            }
        }
        findRooms.removeAll(toDel);

        return findRooms;
    }


}
