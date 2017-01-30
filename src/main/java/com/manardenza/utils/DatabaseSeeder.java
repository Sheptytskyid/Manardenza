package com.manardenza.utils;

import com.manardenza.dao.HotelDaoImpl;
import com.manardenza.dao.ReservationDaoImpl;
import com.manardenza.dao.UserDaoImpl;
import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;
import com.manardenza.entity.User;

import java.util.ArrayList;
import java.util.List;

public final class DatabaseSeeder {

    private static final String KIEV = "Kiev";
    private static final String ODESSA = "Odessa";
    private static final String LVOV = "Lvov";
    private static final String DONETSK = "Donetsk";
    private static final String ZAPOROZHYE = "Zaporozhye";
    private static final String MARRIOTT = "Marriott";
    private static final String HOLIDAY_INN = "Holiday Inn";
    private static final String REIKARTZ = "Reikartz";
    private static final UserDaoImpl USERDAOIMPL = UserDaoImpl.getInstance();
    private static final HotelDaoImpl HOTELDAOIMPL = HotelDaoImpl.getInstance();
    private static final ReservationDaoImpl RESERVATIONDAOIMPL = ReservationDaoImpl.getInstance();

    private static List<Room> roomsSeederList = new ArrayList<>();

    public static void seedDatabase() {
        USERDAOIMPL.save(new User("Vasya", "Petrov"));
        USERDAOIMPL.save(new User("Anton", "Chechov"));
        USERDAOIMPL.save(new User("Natalia", "Novikova"));
        USERDAOIMPL.save(new User("Igor", "Sidorov"));
        USERDAOIMPL.save(new User("Vasya", "Ivanov"));
        USERDAOIMPL.save(new User("Kolya", "Pyatkin"));
        USERDAOIMPL.save(new User("Andrey", "Semenov"));
        USERDAOIMPL.save(new User("Katya", "Zagorodnaja"));
        USERDAOIMPL.save(new User("Marina", "Semionova"));
        USERDAOIMPL.save(new User("Jozef", "Pavlik"));
        USERDAOIMPL.save(new User("Dariusz", "Maciewski"));
        USERDAOIMPL.save(new User("Andrzej", "Donica"));
        USERDAOIMPL.save(new User("Sergey", "Godovany"));
        USERDAOIMPL.save(new User("Scolastyka", "Machura"));
        USERDAOIMPL.save(new User("Ann", "Merryvether"));

        roomsSeederList.add(new Room("SINGLE ROOM", 1, 200));
        roomsSeederList.add(new Room("DOUBLE ROOM", 2, 300));
        roomsSeederList.add(new Room("KING BEDROOM", 2, 350));
        roomsSeederList.add(new Room("INTERCONNECTING ROOMS", 3, 400));
        roomsSeederList.add(new Room("INTERCONNECTING ROOMS", 4, 450));
        roomsSeederList.add(new Room("DUPLEX", 4, 700));
        roomsSeederList.add(new Room("SUITE ROOM", 6, 1000));

        HOTELDAOIMPL.save(new Hotel(MARRIOTT, KIEV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(MARRIOTT, ODESSA, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(MARRIOTT, LVOV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(MARRIOTT, DONETSK, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(MARRIOTT, ZAPOROZHYE, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(HOLIDAY_INN, KIEV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(HOLIDAY_INN, ODESSA, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(HOLIDAY_INN, LVOV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(HOLIDAY_INN, DONETSK, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(HOLIDAY_INN, ZAPOROZHYE, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(REIKARTZ, KIEV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(REIKARTZ, ODESSA, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(REIKARTZ, LVOV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(REIKARTZ, DONETSK, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(REIKARTZ, ZAPOROZHYE, roomsSeederList));
    }
}