package com.manardenza.controller;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;
import com.manardenza.entity.User;
import com.manardenza.servise.HotelService;

import java.util.List;
import java.util.Map;

public class HotelController {

    private static HotelController instance;
    private HotelService hotelService;

    private HotelController() {
        hotelService = HotelService.getInstance();
    }

    public static HotelController getInstance() {
        if (instance == null) {
            instance = new HotelController();
        }
        return instance;
    }

    public void userRegistration(User userToRegistration) {
        hotelService.userRegistration(userToRegistration);
    }

    public List<Hotel> findHotelByName(String hotelName) {
        return hotelService.findHotelByName(hotelName);
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return hotelService.findHotelByCity(cityName);
    }

    public Room bookRoom(long roomId, long userId, long hotelId, long bookingFrom) {
        return hotelService.bookRoom(roomId, userId, hotelId, bookingFrom);
    }

    public boolean cancelReservation(long roomId, long userId, long hotelId, long bookingId) {
        return hotelService.cancelReservation(roomId, userId, hotelId, bookingId);
    }

    public List<Room> findRoom(Map<String, String> params) {
        return hotelService.findRoom(params);
    }
}
