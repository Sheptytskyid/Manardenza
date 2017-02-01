package com.manardenza.controller;

import com.manardenza.entity.User;
import com.manardenza.login.CurrentUser;
import com.manardenza.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserService userService;
    @Mock
    private CurrentUser currentUser;
    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        when(currentUser.getUser()).thenReturn(new User("Name", "Surname"));
    }

    @Test
    public void loginUserCallsServiceMethod() throws Exception {
        userController.loginUser(null, null);
        verify(userService, times(1)).loginUser(null, null);
    }

    @Test
    public void logoutUserCallsServiceMethod() throws Exception {
        userController.logoutUser();
        verify(userService, times(1)).logoutUser();
    }

}