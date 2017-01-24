package entities;

import lombok.Data;

public @Data class Room {

    private long id;
    private int person;
    private int price;
    private User orderedUser;

}
