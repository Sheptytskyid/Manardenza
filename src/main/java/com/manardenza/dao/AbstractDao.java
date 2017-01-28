package com.manardenza.dao;

import com.manardenza.entity.AbstractObject;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends AbstractObject> {

    protected List<T> database = new ArrayList<>();

    public T save(T obj) {
        database.add(obj);
        return obj;
    }

    public boolean delete(T obj) {
        return database.remove(obj);
    }

    public boolean saveAll(List<T> list) {
        return database.addAll(list);
    }

    public List<T> getAll() {
        return database;
    }
}