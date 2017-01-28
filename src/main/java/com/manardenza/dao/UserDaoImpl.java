package com.manardenza.dao;

import com.manardenza.entity.User;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> {

    private static UserDaoImpl instance;

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public User getUserByName(String firstName, String lastName) {
        Optional<User> user = userList.stream().filter(param -> param.getFirstName().equals(firstName) && param
            .getLastName().equals(lastName)).findFirst();
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
