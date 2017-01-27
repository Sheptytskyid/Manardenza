package com.manardenza.utils;

import com.manardenza.entity.Hotel;
import com.manardenza.entity.Room;
import com.manardenza.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSeeder {

    @Getter private static List<User> usersList = new ArrayList<>();
    @Getter private static List<Room> roomsList = new ArrayList<>();
    @Getter private static List<Hotel> hotelsList = new ArrayList<>();

    static {
        usersList.add(new User(464655, "Vasya", "Petrov"));
        usersList.add(new User(546466, "Anton", "Chechov"));
        usersList.add(new User(566656, "Natalia", "Novikova"));
        usersList.add(new User(848466, "Igor", "Petrov"));
        usersList.add(new User(894656, "Vasya", "Ivanov"));
        usersList.add(new User(894565, "Kolya", "Petrov"));
        usersList.add(new User(435168, "Andrey", "Semenov"));
        usersList.add(new User(684616, "Katya", "Zagorodnaja"));
        usersList.add(new User(684646, "Marina", "Semionova"));
        usersList.add(new User(584689, "Jozef", "Pavlik"));
        usersList.add(new User(756161, "Dariusz", "Maciewski"));
        usersList.add(new User(654846, "Andrzej", "Donica"));
        usersList.add(new User(314688, "Sergey", "Godovany"));
        usersList.add(new User(786146, "Scolastyka", "Machura"));
        usersList.add(new User(894664, "Ann", "Merryvether"));

        roomsList.add(new Room(56464646, "SINGLE ROOM", 1, 200, null));
        roomsList.add(new Room(78949466, "DOUBLE ROOM", 2, 300, null));
        roomsList.add(new Room(74646566, "KING BEDROOM", 2, 350, null));
        roomsList.add(new Room(68408949, "INTERCONNECTING ROOMS", 3, 400, null));
        roomsList.add(new Room(54400088, "INTERCONNECTING ROOMS", 4, 450, null));
        roomsList.add(new Room(84706849, "DUPLEX", 4, 700, null));
        roomsList.add(new Room(80886444, "SUITE ROOM", 6, 1000, null));

        hotelsList.add(new Hotel(684464684, "Marriott", "Kiev", roomsList));
        hotelsList.add(new Hotel(649464689, "Marriott", "Odessa", roomsList));
        hotelsList.add(new Hotel(849849464, "Marriott", "Lvov", roomsList));
        hotelsList.add(new Hotel(653548446, "Marriott", "Donetsk", roomsList));
        hotelsList.add(new Hotel(876616656, "Marriott", "Zaporozhye", roomsList));
        hotelsList.add(new Hotel(214546684, "Holiday Inn", "Kiev", roomsList));
        hotelsList.add(new Hotel(756464564, "Holiday Inn", "Odessa", roomsList));
        hotelsList.add(new Hotel(955545454, "Holiday Inn", "Lvov", roomsList));
        hotelsList.add(new Hotel(735465465, "Holiday Inn", "Donetsk", roomsList));
        hotelsList.add(new Hotel(315468787, "Holiday Inn", "Zaporozhye", roomsList));
        hotelsList.add(new Hotel(346864847, "Reikartz", "Kiev", roomsList));
        hotelsList.add(new Hotel(945425451, "Reikartz", "Lvov", roomsList));
        hotelsList.add(new Hotel(345684884, "Reikartz", "Kiev", roomsList));
        hotelsList.add(new Hotel(753456466, "Reikartz", "Donetsk", roomsList));
        hotelsList.add(new Hotel(456468498, "Reikartz", "Zaporozhye", roomsList));
    }
}
