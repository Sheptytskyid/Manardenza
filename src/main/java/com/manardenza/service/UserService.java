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

    public void loginUser(String firstName, String lastName) {
        User user = userDao.getUserByName(firstName, lastName);
        if (user == null) {
            user = registerNewUser(firstName, lastName);
        }
        CurrentUser.getInstance().setUser(user);
    }

    private User registerNewUser(String firstName, String lastName) {
        return userDao.save(new User(firstName, lastName));
    }
}
