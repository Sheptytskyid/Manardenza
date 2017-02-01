package com.manardenza.controller;

import com.manardenza.login.CurrentUser;
import com.manardenza.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserService userService;
    @Mock
    private CurrentUser currentUser;
    @InjectMocks
    private UserController userController;

    @Test
    public void loginUser() throws Exception {
        String firstName = "Name";
        String lastName = "Surname";
        userController.loginUser(firstName, lastName);
        Mockito.verify(userService, Mockito.times(1)).loginUser(firstName, lastName);
    }

    @Test
    public void logoutUser() throws Exception {
        userController.logoutUser();
        Mockito.verify(userService, Mockito.times(1)).logoutUser();
    }

}