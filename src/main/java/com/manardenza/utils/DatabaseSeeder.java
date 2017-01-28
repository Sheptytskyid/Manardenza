package com.manardenza.utils;

import com.manardenza.dao.HotelDaoImpl;
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

    private static List<Room> roomsSeederList = new ArrayList<>();

    public static void seedDatabase() {
        USERDAOIMPL.save(new User(464655, "Vasya", "Petrov"));
        USERDAOIMPL.save(new User(546466, "Anton", "Chechov"));
        USERDAOIMPL.save(new User(566656, "Natalia", "Novikova"));
        USERDAOIMPL.save(new User(848466, "Igor", "Sidorov"));
        USERDAOIMPL.save(new User(894656, "Vasya", "Ivanov"));
        USERDAOIMPL.save(new User(894565, "Kolya", "Pyatkin"));
        USERDAOIMPL.save(new User(435168, "Andrey", "Semenov"));
        USERDAOIMPL.save(new User(684616, "Katya", "Zagorodnaja"));
        USERDAOIMPL.save(new User(684646, "Marina", "Semionova"));
        USERDAOIMPL.save(new User(584689, "Jozef", "Pavlik"));
        USERDAOIMPL.save(new User(756161, "Dariusz", "Maciewski"));
        USERDAOIMPL.save(new User(654846, "Andrzej", "Donica"));
        USERDAOIMPL.save(new User(314688, "Sergey", "Godovany"));
        USERDAOIMPL.save(new User(786146, "Scolastyka", "Machura"));
        USERDAOIMPL.save(new User(894664, "Ann", "Merryvether"));

        roomsSeederList.add(new Room("SINGLE ROOM", 1, 200, null));
        roomsSeederList.add(new Room("DOUBLE ROOM", 2, 300, null));
        roomsSeederList.add(new Room("KING BEDROOM", 2, 350, null));
        roomsSeederList.add(new Room("INTERCONNECTING ROOMS", 3, 400, null));
        roomsSeederList.add(new Room("INTERCONNECTING ROOMS", 4, 450, null));
        roomsSeederList.add(new Room("DUPLEX", 4, 700, null));
        roomsSeederList.add(new Room("SUITE ROOM", 6, 1000, null));

        HOTELDAOIMPL.save(new Hotel(684464684, MARRIOTT, KIEV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(649464689, MARRIOTT, ODESSA, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(849849464, MARRIOTT, LVOV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(653548446, MARRIOTT, DONETSK, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(876616656, MARRIOTT, ZAPOROZHYE, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(214546684, HOLIDAY_INN, KIEV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(756464564, HOLIDAY_INN, ODESSA, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(955545454, HOLIDAY_INN, LVOV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(735465465, HOLIDAY_INN, DONETSK, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(315468787, HOLIDAY_INN, ZAPOROZHYE, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(346864847, REIKARTZ, KIEV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(945425451, REIKARTZ, ODESSA, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(345684884, REIKARTZ, LVOV, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(753456466, REIKARTZ, DONETSK, roomsSeederList));
        HOTELDAOIMPL.save(new Hotel(456468498, REIKARTZ, ZAPOROZHYE, roomsSeederList));
    }
}
