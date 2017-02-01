package com.manardenza.service;

import com.manardenza.dao.ReservationDaoImpl;
import com.manardenza.entity.Hotel;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;
import com.manardenza.login.CurrentUser;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ReservationService {

    private ReservationDaoImpl reservationDao;
    private CurrentUser currentUser = CurrentUser.getInstance();

    public ReservationService(ReservationDaoImpl reservationDao) {
        this.reservationDao = reservationDao;
    }

    public Long bookRoom(Date reservedFrom, Date reservedTo, Room room, Hotel hotel) {
        Reservation newReservation = new Reservation(reservedFrom, reservedTo, currentUser.getUser(), room, hotel);
        reservationDao.save(newReservation);

        return newReservation.getId();
    }

    public boolean cancelReservation(long idReservation) {
        return reservationDao.delete(reservationDao.getAll().stream()
                .filter(p -> p.getId() == idReservation)
                .findFirst()
                .get());
    }

    public Map<String, List<Room>> checkRoomReservation(Date reservedFrom, Date reservedTo,
                                                        Map<String, List<Room>> rooms) {
        for (Map.Entry<String, List<Room>> entry : rooms.entrySet()) {
            entry.setValue(selectAvailableRooms(reservedFrom, reservedTo, entry.getValue()));
        }
        return rooms;
    }

    private List<Room> selectAvailableRooms(Date reservedFrom, Date reservedTo, List<Room> rooms) {
        return reservationDao.getAll().stream()
                .filter(reservation -> rooms.contains(reservation.getReservedRoom()))
                .filter(reservation -> !reservation.overlaps(reservedFrom, reservedTo))
                .map(Reservation::getReservedRoom)
                .collect(Collectors.toList());
    }

    public List<Reservation> getAllUserReservations() {
        return reservationDao.getAll().stream()
                .filter(reservation -> reservation.getReservedUser().equals(currentUser.getUser()))
                .collect(Collectors.toList());
    }
}
