package com.manardenza.controller;

import com.manardenza.entity.User;
import com.manardenza.service.UserService;

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

    public void registerUser(String firstName, String lastName) {
        userService.registerUser(firstName, lastName);
    }
}
