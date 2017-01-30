package com.manardenza.controller;

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

    public void loginUser(String firstName, String lastName) {
        userService.loginUser(firstName, lastName);
    }

    public void logoutUser() {
        userService.logoutUser();
    }
}
