package entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public class Hotel extends Room {

    private long id;
    private String name;
    private String city;

    public Hotel(long id, int person, int price, User orderedUser, long id1, String name, String city) {
        super(id, person, price, orderedUser);
        this.id = id1;
        this.name = name;
        this.city = city;
    }
}
