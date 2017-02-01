package com.manardenza.service;

import com.manardenza.login.CurrentUser;
import com.manardenza.utils.Injector;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    private static UserService userService;
    private static CurrentUser currentUser;

    @BeforeClass
    public static void beforeTest() {
        userService = Injector.getUserService();
        currentUser = CurrentUser.getInstance();
    }

    @Test
    public void loginUser() throws Exception {
        String firstName = "Test";
        String lastName = "User";
        String fullName = firstName + " " + lastName;
        userService.loginUser(firstName, lastName);
        assertEquals(currentUser.getUser().getFullName(), fullName);
    }

    @Test
    public void logoutUser() throws Exception {
        loginUser();
        userService.logoutUser();
        assertEquals(currentUser.getUser(), null);
    }
}