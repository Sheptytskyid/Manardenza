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

    private DatabaseSeeder() {
    }

    @Getter private static List<User> usersList = new ArrayList<>();
    @Getter private static List<Room> roomsList = new ArrayList<>();
    @Getter private static List<Hotel> hotelsList = new ArrayList<>();

    static {
        usersList.add(new User(464655, "Vasya", "Petrov"));
        usersList.add(new User(546466, "Anton", "Chechov"));
        usersList.add(new User(566656, "Natalia", "Novikova"));
        usersList.add(new User(848466, "Igor", "Sidorov"));
        usersList.add(new User(894656, "Vasya", "Ivanov"));
        usersList.add(new User(894565, "Kolya", "Pyatkin"));
        usersList.add(new User(435168, "Andrey", "Semenov"));
        usersList.add(new User(684616, "Katya", "Zagorodnaja"));
        usersList.add(new User(684646, "Marina", "Semionova"));
        usersList.add(new User(584689, "Jozef", "Pavlik"));
        usersList.add(new User(756161, "Dariusz", "Maciewski"));
        usersList.add(new User(654846, "Andrzej", "Donica"));
        usersList.add(new User(314688, "Sergey", "Godovany"));
        usersList.add(new User(786146, "Scolastyka", "Machura"));
        usersList.add(new User(894664, "Ann", "Merryvether"));

        roomsList.add(new Room("SINGLE ROOM", 1, 200, null));
        roomsList.add(new Room("DOUBLE ROOM", 2, 300, null));
        roomsList.add(new Room("KING BEDROOM", 2, 350, null));
        roomsList.add(new Room("INTERCONNECTING ROOMS", 3, 400, null));
        roomsList.add(new Room("INTERCONNECTING ROOMS", 4, 450, null));
        roomsList.add(new Room("DUPLEX", 4, 700, null));
        roomsList.add(new Room("SUITE ROOM", 6, 1000, null));

        hotelsList.add(new Hotel(684464684, MARRIOTT, KIEV, roomsList));
        hotelsList.add(new Hotel(649464689, MARRIOTT, ODESSA, roomsList));
        hotelsList.add(new Hotel(849849464, MARRIOTT, LVOV, roomsList));
        hotelsList.add(new Hotel(653548446, MARRIOTT, DONETSK, roomsList));
        hotelsList.add(new Hotel(876616656, MARRIOTT, ZAPOROZHYE, roomsList));
        hotelsList.add(new Hotel(214546684, HOLIDAY_INN, KIEV, roomsList));
        hotelsList.add(new Hotel(756464564, HOLIDAY_INN, ODESSA, roomsList));
        hotelsList.add(new Hotel(955545454, HOLIDAY_INN, LVOV, roomsList));
        hotelsList.add(new Hotel(735465465, HOLIDAY_INN, DONETSK, roomsList));
        hotelsList.add(new Hotel(315468787, HOLIDAY_INN, ZAPOROZHYE, roomsList));
        hotelsList.add(new Hotel(346864847, REIKARTZ, KIEV, roomsList));
        hotelsList.add(new Hotel(945425451, REIKARTZ, ODESSA, roomsList));
        hotelsList.add(new Hotel(345684884, REIKARTZ, LVOV, roomsList));
        hotelsList.add(new Hotel(753456466, REIKARTZ, DONETSK, roomsList));
        hotelsList.add(new Hotel(456468498, REIKARTZ, ZAPOROZHYE, roomsList));
    }
}
