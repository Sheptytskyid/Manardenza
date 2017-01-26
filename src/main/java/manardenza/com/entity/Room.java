package manardenza.com.entity;

import lombok.Data;
import org.apache.commons.lang3.tuple.Triple;

import java.time.LocalDate;
import java.util.List;

@Data
public class Room extends AbstractObject {

    private String name;
    private int person;
    private int price;
    private List<Triple<LocalDate, LocalDate, User>> userReserved;

    public Room(long id, String name, int person, int price, List<Triple<LocalDate, LocalDate, User>> userReserved) {
        super(id);
        this.name = name;
        this.person = person;
        this.price = price;
        this.userReserved = userReserved;
    }
}
