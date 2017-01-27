package com.manardenza.utils;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;
import com.manardenza.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSeeder {

    private static final String KIEV = "Kiev";
    private static final String ODESSA = "Odessa";
    private static final String LVOV = "Lvov";
    private static final String DONETSK = "Donetsk";
    private static final String ZAPOROZHYE = "Zaporozhye";
    private static final String MARRIOTT = "Marriott";
    private static final String HOLIDAY_INN = "Holiday Inn";
    private static final String REIKARTZ = "Reikartz";

    @Getter protected static List<User> usersSeederList = new ArrayList<>();
    @Getter protected static List<Room> roomsSeederList = new ArrayList<>();
    @Getter protected static List<Hotel> hotelsSeederList = new ArrayList<>();

    static {
        usersSeederList.add(new User(464655, "Vasya", "Petrov"));
        usersSeederList.add(new User(546466, "Anton", "Chechov"));
        usersSeederList.add(new User(566656, "Natalia", "Novikova"));
        usersSeederList.add(new User(848466, "Igor", "Sidorov"));
        usersSeederList.add(new User(894656, "Vasya", "Ivanov"));
        usersSeederList.add(new User(894565, "Kolya", "Pyatkin"));
        usersSeederList.add(new User(435168, "Andrey", "Semenov"));
        usersSeederList.add(new User(684616, "Katya", "Zagorodnaja"));
        usersSeederList.add(new User(684646, "Marina", "Semionova"));
        usersSeederList.add(new User(584689, "Jozef", "Pavlik"));
        usersSeederList.add(new User(756161, "Dariusz", "Maciewski"));
        usersSeederList.add(new User(654846, "Andrzej", "Donica"));
        usersSeederList.add(new User(314688, "Sergey", "Godovany"));
        usersSeederList.add(new User(786146, "Scolastyka", "Machura"));
        usersSeederList.add(new User(894664, "Ann", "Merryvether"));

        roomsSeederList.add(new Room("SINGLE ROOM", 1, 200, null));
        roomsSeederList.add(new Room("DOUBLE ROOM", 2, 300, null));
        roomsSeederList.add(new Room("KING BEDROOM", 2, 350, null));
        roomsSeederList.add(new Room("INTERCONNECTING ROOMS", 3, 400, null));
        roomsSeederList.add(new Room("INTERCONNECTING ROOMS", 4, 450, null));
        roomsSeederList.add(new Room("DUPLEX", 4, 700, null));
        roomsSeederList.add(new Room("SUITE ROOM", 6, 1000, null));

        hotelsSeederList.add(new Hotel(684464684, MARRIOTT, KIEV, roomsSeederList));
        hotelsSeederList.add(new Hotel(649464689, MARRIOTT, ODESSA, roomsSeederList));
        hotelsSeederList.add(new Hotel(849849464, MARRIOTT, LVOV, roomsSeederList));
        hotelsSeederList.add(new Hotel(653548446, MARRIOTT, DONETSK, roomsSeederList));
        hotelsSeederList.add(new Hotel(876616656, MARRIOTT, ZAPOROZHYE, roomsSeederList));
        hotelsSeederList.add(new Hotel(214546684, HOLIDAY_INN, KIEV, roomsSeederList));
        hotelsSeederList.add(new Hotel(756464564, HOLIDAY_INN, ODESSA, roomsSeederList));
        hotelsSeederList.add(new Hotel(955545454, HOLIDAY_INN, LVOV, roomsSeederList));
        hotelsSeederList.add(new Hotel(735465465, HOLIDAY_INN, DONETSK, roomsSeederList));
        hotelsSeederList.add(new Hotel(315468787, HOLIDAY_INN, ZAPOROZHYE, roomsSeederList));
        hotelsSeederList.add(new Hotel(346864847, REIKARTZ, KIEV, roomsSeederList));
        hotelsSeederList.add(new Hotel(945425451, REIKARTZ, ODESSA, roomsSeederList));
        hotelsSeederList.add(new Hotel(345684884, REIKARTZ, LVOV, roomsSeederList));
        hotelsSeederList.add(new Hotel(753456466, REIKARTZ, DONETSK, roomsSeederList));
        hotelsSeederList.add(new Hotel(456468498, REIKARTZ, ZAPOROZHYE, roomsSeederList));
    }
}
