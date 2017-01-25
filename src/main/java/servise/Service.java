package servise;

import entities.Hotel;
import entities.Room;
import entities.User;

import java.util.List;
import java.util.Map;

public class Service {

    public  void userRegistration(User userToRegistration) {

    }

    public List<Hotel> findHotelByName(String hotelName) {
        return null;
    }

    public List<Hotel> findHotelByCity(String cityName) {
        return null;
    }

    public Room bookRoom(long roomId, long userId, long hotelId) {
        return null;
    }

    public boolean cancelReservation(long roomId, long userId, long hotelId) {
        return false;
    }

    public List<Room> findRoom(Map<String, String> params) {
        return null;
    }
}
