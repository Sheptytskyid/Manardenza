package com.manardenza.controller;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;
import com.manardenza.service.HotelService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public List<Hotel> findHotelByName(String hotelName) {
        return hotelService.findHotelByName(hotelName);
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return hotelService.findHotelByCity(cityName);
    }

    public Map<String, List<Room>> findPreliminaryRoom(String city, int persons, int price) {
        return hotelService.findPreliminaryRoom(city, persons, price);
    }

    public Map<String, List<Room>> getAvailableRooms(String city, int persons, int price,
                                                     Date reservedFrom, Date reservedTo) {
        return hotelService.getAvailableRooms(city, persons, price, reservedFrom, reservedTo);
    }
}
