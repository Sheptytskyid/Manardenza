package controller;

import entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Controller<T> {

    ArrayList<Hotel> hotelArrayList = new ArrayList();

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
