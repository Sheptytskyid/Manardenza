package com.manardenza.dao;

import com.manardenza.entity.Hotel;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Hotel> getHotelsByName(String name) {
        return getAll().stream()
                .filter(hotel -> hotel.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Hotel> getHotelsByCity(String city) {
        return getAll().stream()
                .filter(hotel -> hotel.getCity().equals(city))
                .collect(Collectors.toList());
    }
}