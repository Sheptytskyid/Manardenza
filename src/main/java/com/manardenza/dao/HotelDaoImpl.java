package com.manardenza.dao;

import com.manardenza.entity.Hotel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Hotel> getAll() {
        return database;
    }

    public List<Hotel> getHotelsByName(String hotelName) {
        return new ArrayList<>();
    }

    public List<Hotel> getHotelsByCity(String hotelCity) {
        return new ArrayList<>();
    }
}