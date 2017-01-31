package com.manardenza.controller;

import com.manardenza.service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void loginUser(String firstName, String lastName) {
        userService.loginUser(firstName, lastName);
    }

    public void logoutUser() {
        userService.logoutUser();
    }
}
