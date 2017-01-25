package entities;

import lombok.Data;

@Data
public class Room {

    private long id;
    private int person;
    private int price;
    private User orderedUser;

}
