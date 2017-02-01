package com.manardenza.service;

import com.manardenza.dao.HotelDaoImpl;
import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class HotelService {

    private HotelDaoImpl hotelDao;
    private ReservationService reservationService;

    public HotelService(HotelDaoImpl hotelDao) {
        this.hotelDao = hotelDao;
    }

    public List<Hotel> findHotelByName(String hotelName) {
        return hotelDao.getHotelsByName(hotelName);
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return hotelDao.getHotelsByCity(cityName);
    }

    public Map<String, List<Room>> getAvailableRooms(String city, int persons, int price,
                                                     Date reservedFrom, Date reservedTo) {
        return reservationService.checkRoomReservation(reservedFrom, reservedTo,
                findPreliminaryRoom(city, persons, price));
    }

    public Map<String, List<Room>> findPreliminaryRoom(String city, int persons, int price) {
        Map<String, List<Room>> map = new HashMap<>();
        hotelDao.getHotelsByCity(city).forEach(hotel -> map.put(hotel.getName(), findRoom(hotel, persons, price)));
        return map;
    }

    private List<Room> findRoom(Hotel hotel, int persons, int price) {
        return hotel.getRooms().stream()
                .filter(room -> room.getPerson() == persons)
                .filter(room -> room.getPrice() <= price)
                .collect(Collectors.toList());
    }
}
