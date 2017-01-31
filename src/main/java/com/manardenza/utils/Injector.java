package com.manardenza.utils;

import com.manardenza.controller.HotelController;
import com.manardenza.controller.UserController;
import com.manardenza.dao.HotelDaoImpl;
import com.manardenza.dao.UserDaoImpl;
import com.manardenza.login.CurrentUser;
import com.manardenza.service.HotelService;
import com.manardenza.service.UserService;
import lombok.Getter;

import java.io.File;

public class Injector {
    private static File hotelsDatabaseFile = new File("src/main/resources/databaseFiles/databaseHotelsFile.bin");
    private static File usersDatabaseFile = new File("src/main/resources/databaseFiles/databaseUsersFile.bin");
    @Getter
    private static HotelDaoImpl hotelDao = new HotelDaoImpl(hotelsDatabaseFile);
    @Getter
    private static UserDaoImpl userDao = new UserDaoImpl(usersDatabaseFile);
    private static HotelService hotelService = new HotelService(hotelDao);
    private static UserService userService = new UserService(userDao, CurrentUser.getInstance());
    private static HotelController hotelController = new HotelController(hotelService);
    private static UserController userController = new UserController(userService);

}
