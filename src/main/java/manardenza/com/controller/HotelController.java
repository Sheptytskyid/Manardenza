package manardenza.com.controller;

import manardenza.com.entity.Hotel;
import manardenza.com.entity.Room;
import manardenza.com.entity.User;
import manardenza.com.servise.HotelService;

import java.util.List;
import java.util.Map;

public class HotelController {

    private static HotelController instance;
    private HotelService hotelService;

    public HotelController() {
        hotelService = HotelService.getInstance();
    }

    public static HotelController getInstance() {
        if (instance == null) {
            instance = new HotelController();
        }
        return instance;
    }

    public void userRegistration(User userToRegistration) {
        hotelService.userRegistration(userToRegistration);
    }

    public List<Hotel> findHotelByName(String hotelName) {
        return hotelService.findHotelByName(hotelName);
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return hotelService.findHotelByCity(cityName);
    }

    public Room bookRoom(long roomId, long userId, long hotelId) {
        return hotelService.bookRoom(roomId, userId, hotelId);
    }

    public boolean cancelReservation(long roomId, long userId, long hotelId) {
        return hotelService.cancelReservation(roomId, userId, hotelId);
    }

    public List<Room> findRoom(Map<String, String> params) {
        return hotelService.findRoom(params);
    }
}
