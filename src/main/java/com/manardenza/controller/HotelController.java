package com.manardenza.controller;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;
import com.manardenza.servise.HotelService;

import java.util.List;
import java.util.Map;

public class HotelController {

    private static HotelController instance;
    private HotelService hotelService;

    private HotelController() {
        this.hotelService = HotelService.getInstance();
    }

    public static HotelController getInstance() {
        if (instance == null) {
            instance = new HotelController();
        }
        return instance;
    }

    public List<Hotel> findHotelByName(String hotelName) {
        return hotelService.findHotelByName(hotelName);
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return hotelService.findHotelByCity(cityName);
    }

    public Room bookRoom(long roomId, long hotelId, Reservation reservation) {
        return hotelService.bookRoom(roomId, hotelId, reservation);
    }

    public boolean cancelReservation(long roomId, long userId, long hotelId, Reservation reservation) {
        return hotelService.cancelReservation(roomId, userId, hotelId, reservation);
    }

    public List<Room> findRoom(Map<String, String> params) {
        return hotelService.findRoom(params);
    }
}
