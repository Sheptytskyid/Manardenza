package com.manardenza.dao;

import com.manardenza.entity.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDaoImpl extends AbstractDao<Hotel> {

    private static HotelDaoImpl instance;

    private HotelDaoImpl() {
    }

    public static HotelDaoImpl getInstance() {
        if (instance == null) {
            instance = new HotelDaoImpl();
        }
        return instance;
    }

    public ArrayList<Hotel> getHotelsByName(String hotelName) {
        return null;
    }

    public ArrayList<Hotel> getHotelsByCity(String hotelCity) {
        return null;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelList;
    }
}
