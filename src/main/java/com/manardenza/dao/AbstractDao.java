package com.manardenza.dao;

import com.manardenza.entity.AbstractObject;
import com.manardenza.entity.Hotel;
import com.manardenza.entity.User;
import com.manardenza.utils.DatabaseSeeder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends AbstractObject> extends DatabaseSeeder {

    protected List<Hotel> hotelList = hotelsSeederList;
    protected List<User> userlList = usersSeederList;

    public T save(T obj) {
        return obj;
    }

    public boolean delete(T obj) {
        return false;
    }

    public boolean saveAll(List<T> obj) {
        return false;
    }

    public List<T> getAll() {
        return null;
    }

    public ArrayList<Hotel> getHotelsByName(String hotelName) {
        return null;
    }

    public ArrayList<Hotel> getHotelsByCity(String hotelCity) {
        return null;
    }
}
