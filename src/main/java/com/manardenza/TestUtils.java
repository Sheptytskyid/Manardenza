package com.manardenza;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;
import com.manardenza.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

    public static final String HOTEL_NAME = "Mariott";
    public static final String CITY = "Kiev";
    public static final String FIRST_NAME = "Name";
    public static final String LAST_NAME = "Surname";
    public static final Date RESERVED_FROM = new Date(117, 1, 10);
    public static final Date RESERVED_TO = new Date(117, 1, 15);
    public static final User USER = new User(FIRST_NAME, LAST_NAME);
    public static final Room ROOM = new Room("Room", 2, 300);
    public static final List<Room> ROOMS_LIST = new ArrayList<>();
    public static final Hotel HOTEL = new Hotel(HOTEL_NAME, CITY, ROOMS_LIST);
    public static final Map<String, List<Room>> ROOMS_MAP = new HashMap<>();

    private TestUtils() {}

}
