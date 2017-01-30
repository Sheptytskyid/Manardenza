package com.manardenza.service;

import com.manardenza.dao.ReservationDaoImpl;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, List<Room>> checkRoomReservation(Date reservedFrom, Date reservedTo,
                                                        Map<String, List<Room>> rooms) {
        for (Map.Entry<String, List<Room>> entry : rooms.entrySet()) {
            entry.setValue(selectAvailableRooms(reservedFrom, reservedTo, entry.getValue()));
        }
        return rooms;
    }

    private List<Room> selectAvailableRooms(Date reservedFrom, Date reservedTo, List<Room> rooms) {
        List<Room> roomsToDelete = new ArrayList<>();
        for (Room room : rooms) {
            if (reservationDao.getAll().stream()
                    .filter(reservation -> reservation.getReservedRoom().equals(room))
                    .filter(reservation -> reservation.overlaps(reservedFrom, reservedTo))
                    .count() > 0) {
                roomsToDelete.add(room);
            }
        }
        rooms.removeAll(roomsToDelete);

        return rooms;
    }

}
