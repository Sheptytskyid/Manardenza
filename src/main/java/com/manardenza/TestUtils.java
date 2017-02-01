package com.manardenza;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Reservation;
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
    public static final Hotel HOTEL = new Hotel(HOTEL_NAME, CITY, getRoomsSeedList());
    public static final Map<String, List<Room>> ROOMS_MAP = new HashMap<>();

    public static List<Room> getRoomsSeedList() {
        List<Room> testRoomsList = new ArrayList<>();
        testRoomsList.add(new Room("DOUBLE ROOM", 2, 300));
        testRoomsList.add(new Room("DOUBLE ROOM", 2, 300));
        testRoomsList.add(new Room("DOUBLE ROOM", 2, 300));
        testRoomsList.add(new Room("DOUBLE ROOM", 2, 300));
        testRoomsList.add(new Room("DOUBLE ROOM", 2, 300));
        testRoomsList.add(new Room("DOUBLE ROOM", 2, 300));
        testRoomsList.add(new Room("DOUBLE ROOM", 2, 300));

        return testRoomsList;
    }

    public static List<Reservation> getTestReservationList() {
        List<Reservation> testReservationList = new ArrayList<>();
        testReservationList.add(new Reservation(RESERVED_FROM, RESERVED_TO, USER, getRoomsSeedList().get(0), HOTEL));
        testReservationList.add(new Reservation(RESERVED_FROM, RESERVED_TO, USER, getRoomsSeedList().get(1), HOTEL));
        testReservationList.add(new Reservation(RESERVED_FROM, RESERVED_TO, USER, getRoomsSeedList().get(2), HOTEL));
        testReservationList.add(new Reservation(RESERVED_FROM, RESERVED_TO, USER, getRoomsSeedList().get(3), HOTEL));

        return testReservationList;
    }

    public static List<Room> getRoomsListToReturn() {
        List<Room> roomsListToReturm = new ArrayList<>();
        roomsListToReturm.add(getRoomsSeedList().get(4));
        roomsListToReturm.add(getRoomsSeedList().get(5));
        roomsListToReturm.add(getRoomsSeedList().get(5));
        return roomsListToReturm;
    }

    public static Map<String, List<Room>> getTestRoomsMap() {
        Map<String, List<Room>> testRoomsMap = new HashMap<>();
        testRoomsMap.put(HOTEL_NAME, getRoomsSeedList());
        return testRoomsMap;
    }

    public static Map<String, List<Room>> getTestRoomsToReturnMap() {
        Map<String, List<Room>> testRoomsMap = new HashMap<>();
        testRoomsMap.put(HOTEL_NAME, getRoomsListToReturn());
        return testRoomsMap;
    }

    private TestUtils() {
    }
}
