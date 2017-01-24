package entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public @Data class Hotel extends Room {

    private long id;
    private String name;
    private String city;

}
