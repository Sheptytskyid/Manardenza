package com.manardenza.dao;

import com.manardenza.entity.AbstractObject;
import com.manardenza.entity.Hotel;
import com.manardenza.entity.User;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends AbstractObject> {

    protected List<Hotel> hotelList = new ArrayList<>();
    protected List<User> userList = new ArrayList<>();

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
}
