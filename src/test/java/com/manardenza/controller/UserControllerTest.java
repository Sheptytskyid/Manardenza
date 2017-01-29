package com.manardenza.controller;

import com.manardenza.dao.UserDaoImpl;
import com.manardenza.login.CurrentUser;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserControllerTest {

    private static UserController userController;
    private static CurrentUser currentUser;

    @BeforeClass
    public static void setUp() throws Exception {
        userController = UserController.getInstance();
        currentUser = CurrentUser.getInstance();
    }

    @Test(timeout = 3000)
    public void loginUser() throws Exception {
        String firstName = "Fedor";
        String lastName = "Fedorets";
        userController.loginUser(firstName, lastName);
        assertNotNull(UserDaoImpl.getInstance().getUserByName(firstName, lastName));
    }

    @Test (timeout = 3000)
    public void logoutUser() throws Exception {
        userController.logoutUser();
        assertNull(currentUser.getUser());
    }

}