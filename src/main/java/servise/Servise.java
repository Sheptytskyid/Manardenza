package servise;

import entities.Hotel;
import entities.Room;

import java.util.List;
import java.util.Map;

public class Servise {

    public List<Hotel> findHotelByName(String hotelName) {
        return null;
    }

    public List<Hotel> findHotelByCity(String cityNname) {
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
