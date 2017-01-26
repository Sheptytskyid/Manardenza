package com.manardenza.dao;

import com.manardenza.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao<User> {

    private static UserDaoImpl instance;

    List<User> userlList = new ArrayList<>();

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        return userlList;
    }
}
