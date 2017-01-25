package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Room {

    private long id;
    private String name;
    private int person;
    private int price;
    private List<Triple<Date, Date, User>> userReserved;
}
