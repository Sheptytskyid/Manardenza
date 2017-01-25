package entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Hotel {

    private long id;
    private String name;
    private String city;
    private ArrayList<Room> rooms;
}
