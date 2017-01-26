package manardenza.com.dao;

import manardenza.com.entity.Hotel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> {

    private static AbstractDao instance;

    public static AbstractDao getInstance() {
        if (instance == null) {
            instance = new AbstractDao() {
            };
        }
        return instance;
    }

    public T save(T obj) {
        return obj;
    }

    public boolean delete(T obj) {
        return false;
    }

    public boolean deleteAll(List<T> obj) {
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
