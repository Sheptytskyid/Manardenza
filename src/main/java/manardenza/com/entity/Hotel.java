package manardenza.com.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Hotel extends AbstractObject {

    private String name;
    private String city;
    private ArrayList<Room> rooms;

    public Hotel(long id, String name, String city, ArrayList<Room> rooms) {
        super(id);
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }
}
