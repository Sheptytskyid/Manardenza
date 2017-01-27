package com.manardenza.servise;

import com.manardenza.dao.UserDaoImpl;
import com.manardenza.entity.User;

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

    public void registerUser(User userToRegistration) {
    }
}
