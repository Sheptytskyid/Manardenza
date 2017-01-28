package com.manardenza.service;

import com.manardenza.dao.UserDaoImpl;
import com.manardenza.entity.User;
import com.manardenza.login.CurrentUser;

public class UserService {

    private static UserService instance;
    private UserDaoImpl userDao;

    private UserService() {
        this.userDao = UserDaoImpl.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void registerUser(String firstName, String lastName) {
        User user = UserDaoImpl.getInstance().getUserByName(firstName, lastName);
        if (user == null) {
            user = new User(firstName, lastName);
            UserDaoImpl.getInstance().save(user);
        }
        CurrentUser.getInstance().setUser(user);
    }
}
