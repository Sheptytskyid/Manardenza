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

    public List<Hotel> getHotelsByName(String hotelName) {
        return null;
    }

    public List<Hotel> getHotelsByCity(String hotelCity) {
        return new ArrayList<Hotel>();
    }

    @Override
    public List<Hotel> getAll() {
        return hotelList;
    }
}
