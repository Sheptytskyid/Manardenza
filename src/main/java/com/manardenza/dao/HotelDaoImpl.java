package com.manardenza.dao;

import com.manardenza.entity.Hotel;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class HotelDaoImpl extends AbstractDao<Hotel> {

    private static HotelDaoImpl instance;

    private HotelDaoImpl() {
        databaseFile = new File("src/main/resources/databaseFiles/databaseHotelsFile.bin");
    }

    public static HotelDaoImpl getInstance() {
        if (instance == null) {
            instance = new HotelDaoImpl();
        }
        return instance;
    }

    public List<Hotel> getHotelsByName(String hotelName) {
        return getAll().stream()
                .filter(hotel -> hotel.getName().equals(hotelName))
                .collect(Collectors.toList());
    }

    public List<Hotel> getHotelsByCity(String hotelCity) {
        return getAll().stream()
                .filter(hotel -> hotel.getCity().equals(hotelCity))
                .collect(Collectors.toList());
    }
}