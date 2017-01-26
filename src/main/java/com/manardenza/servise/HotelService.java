package com.manardenza.servise;

import com.manardenza.dao.HotelDaoImpl;
import com.manardenza.dao.UserDaoImpl;
import com.manardenza.entity.Room;
import com.manardenza.entity.User;
import com.manardenza.entity.Hotel;

import java.util.Date;
import java.util.List;
import java.util.Map;

public final class HotelService {

    private static HotelService instance;
    private HotelDaoImpl hotelDao;
    private UserDaoImpl userDao;

    public HotelService() {
        hotelDao = HotelDaoImpl.getInstance();
        userDao = UserDaoImpl.getInstance();
    }

    public static HotelService getInstance() {
        if (instance == null) {
            instance = new HotelService();
        }
        return instance;
    }

    public void userRegistration(User userToRegistration) {

    }

    public List<Hotel> findHotelByName(String hotelName) {
        return null;
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return null;
    }

    public Room bookRoom(long roomId, long userId, long hotelId, long bookingId) {
        return null;
    }

    public boolean cancelReservation(long roomId, long userId, long hotelId, long bookingId) {
        return false;
    }

    public List<Room> findRoom(Map<String, String> params) {
        return null;
    }
}
