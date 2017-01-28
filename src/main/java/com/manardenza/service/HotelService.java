package com.manardenza.service;

import com.manardenza.dao.HotelDaoImpl;
import com.manardenza.entity.Reservation;
import com.manardenza.entity.Room;
import com.manardenza.entity.Hotel;

import java.util.List;
import java.util.Map;

public final class HotelService {

    private static HotelService instance;
    private HotelDaoImpl hotelDao;

    private HotelService() {
        this.hotelDao = HotelDaoImpl.getInstance();
    }

    public static HotelService getInstance() {
        if (instance == null) {
            instance = new HotelService();
        }
        return instance;
    }

    public List<Hotel> findHotelByName(String hotelName) {
        return null;
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return null;
    }

    public Room bookRoom(long roomId, long hotelId, Reservation reservation) {
        return null;
    }

    public boolean cancelReservation(long roomId, long userId, long hotelId, Reservation reservation) {
        return false;
    }

    public List<Room> findRoom(Map<String, String> params) {
        return null;
    }
}
