package com.manardenza.controller;

import com.manardenza.entity.User;
import com.manardenza.servise.UserService;

public class UserController {

    private static UserController instance;
    private UserService userService;

    private UserController() {
        this.userService = UserService.getInstance();
    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public void registerUser(User userToRegistration) {
        userService.registerUser(userToRegistration);
    }
}
